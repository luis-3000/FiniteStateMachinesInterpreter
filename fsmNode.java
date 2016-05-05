import java.util.ArrayList;


public class fsmNode {
	public class MyNode{
		private String myState;
		private String myModifier;
		private ArrayList<MyMap> transitions;
					
		public MyNode(){
			myState = null;
			myModifier = null;
			transitions = new ArrayList<MyMap>();
		}
		public MyNode(String val){
			myState = val;
			myModifier = null;
			transitions = new ArrayList<MyMap>();
		}

		public String getValue(){
			return myState;
		}
		
		public String getModifier(){
			return myModifier;
		}
		 
		public void setValue(String val){
			myState = val;
		}
		
		public ArrayList<MyMap> getTransitions(){
			return transitions;
		}
		
		public void addTransitions(ArrayList<String> transitionsList){
			for(int i = 0; i< temp.size();i++){
				//transitions.add(new something));  //We need to create a transition
			}
			//make sure the transitions are deterministic
			checkDeterministic();
	    }
		public void checkDeterministic(){
		//check if is Deterministic and print UTT if flag
		}
	}
}
