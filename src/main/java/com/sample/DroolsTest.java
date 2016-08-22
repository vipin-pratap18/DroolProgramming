package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import com.sample.model.DecisionString;
import com.test.ruleengine.RuleRunnerEngine;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        /*KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");*/

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            //message.setCalculatedAge(76);
            message.setCalculatedAge(54);
            message.setClientAge(66);
            DecisionString decisionString = new DecisionString(66, 10, 66, 5, 54);
            //new RuleRunnerEngine().runRules(new Object[]{message, decisionString}, new String[]{"Rule Conversion Expiry For Age Less Than"});
            new RuleRunnerEngine().runRules(new Object[]{message, decisionString}, null);
            /*kSession.insert(message);
            kSession.insert(decisionString);*/
           //Executing specific rules from knowledge base
            /* kSession.fireAllRules(new AgendaFilter() {
				
				@Override
				public boolean accept(Match match) {
					boolean returnValue = false;
					String ruleName = match.getRule().getName();
					if(ruleName.equals("Rule Conversion Expiry For Age Less Than"))
						returnValue = true;
						
					return returnValue;
				}
			});*/
            //kSession.fireAllRules();
            //kSession.dispose();
            System.out.println(message.getMessage());
            //kSession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;
        private int calculatedAge;
        private int clientAge;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

		public int getCalculatedAge() {
			return calculatedAge;
		}

		public void setCalculatedAge(int calculatedAge) {
			this.calculatedAge = calculatedAge;
		}

		public int getClientAge() {
			return clientAge;
		}

		public void setClientAge(int clientAge) {
			this.clientAge = clientAge;
		}

    }

}
