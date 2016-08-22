package com.test.ruleengine;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class RuleRunnerEngine {

	public void runRules(Object[] facts, String[] ruleNames){

		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");

		for(int i=0; i<facts.length; i++){
			Object fact = facts[i];
			System.out.println(" inserting fact : "+fact);
			kSession.insert(fact);
		}

		//kSession.fireAllRules();

		if(ruleNames != null){
			//fire specified rules
			/*kSession.fireAllRules(new AgendaFilter() {

				@Override
				public boolean accept(Match match) {
					boolean returnValue = false;
					String ruleName = match.getRule().getName();
					if(ruleName.equals("Rule Conversion Expiry For Age Less Than"))
						returnValue = true;

					return returnValue;
				}
			});*/
			for(String rule : ruleNames)
				kSession.fireAllRules(new CustomAgendaFilter(rule));

		}else{
			//Fire all the rules
			kSession.fireAllRules();
		}
		kSession.dispose();
	}

}

class CustomAgendaFilter implements AgendaFilter{

	private String ruleNameToMatch;

	public CustomAgendaFilter(String ruleName){
		this.ruleNameToMatch = ruleName;
	}

	@Override
	public boolean accept(Match match) {
		boolean returnValue = false;
		String ruleName = match.getRule().getName();
		if(ruleName.equals(ruleNameToMatch))
			returnValue = true;

		return returnValue;
	}

}
