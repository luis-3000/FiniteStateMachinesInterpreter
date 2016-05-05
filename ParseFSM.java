import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseFSM {

	public void parsingFSM(String fsmFile) throws FileNotFoundException{
		int numLinea = 0;
		Scanner in = new Scanner(new File(fsmFile));
		String temp;
		Pattern p;
		Matcher m;

		//First area: make sure the machine name is present
		if(in.hasNextLine()){
			numLinea++;
			String machineName = in.nextLine();
			p = Pattern.compile("\\p{ASCII}+");
			m = p.matcher(machineName);
			if(!m.matches()){
				machineName = null;
				return;
			}else{
				System.out.println();
			}
		}
		//Second area: Skip next line here. 
		in.nextLine();
		numLinea++;

		//Get (non required) alphabet substring if it doesn't match we use the default alphabet
		if(in.hasNextLine()){
			temp = in.nextLine();
			numLinea++;

			p = Pattern.compile("INPUT_ALPHABET\\p{Blank}*:" + "\\p{Blank}*("+ Alphabet.getValidInput() +")\\p{Blank}*");
			m = p.matcher(temp);
			
//			p = Pattern.compile("(0{1})|(|n{1}|d*)");	//We're trying to run our INPUT_ALPHABET	
//			p = Pattern.compile("a*b");
//			m = p.matcher("aaaab");						//and check if actually does work
			
			System.out.println(m.matches());
			
			
			if(m.matches()){
				temp= m.group(1);
				ArrayList<String> inputAlphabet = new ArrayList<String>();
				for(int i = 0; i< temp.length();i++){
					inputAlphabet.add(String.valueOf(temp.charAt(i)));
				}
				if(inputAlphabet.contains("|")){
					temp = "";
					for(int i = 0; i < inputAlphabet.size(); i++){ //need to add Alphabet size to iterate through it.
						if(inputAlphabet.get(i).equals("|")){
							
							//char shortcut = Alphabet.translatePipe(inputAlphabet.get(i));
								
							}
						}else{
							temp = temp + inputAlphabet.get(i);
						}
					}
			}
		}				

			}else{
				System.out.println("FSM FILE ERROR: "+machineName+" : INVALID FORMAT IN LINE NUNBER: "+numLinea+".");
				errorFSM = true;
				return;
			}
}

		//Get Start State
		if(in.hasNextLine()){
			temp = in.nextLine();
			numLinea++;

			p = Pattern.compile("STARTING_STATE\\p{Blank}*:\\p{Blank}*("+BASEALPHABET+")");
			m = p.matcher(temp);
			if(m.find()){
				if(!m.group(1).isEmpty()){
					//if not empty we have another state to go to
				}else{
					System.out.println("FSM FILE ERROR: "+machineName+" : STARTING STATE IS MISSING");
					errorFSM = true;
					return;
				}
			}else{
				System.out.println("FSM FILE ERROR: "+machineName+" : INVALID FORMATTING ON LINE "+numLinea+".");
				errorFSM = true;
				return;	
			}

		}

		in.nextLine();
		numLinea++;

		//Gets all state transitions
		while(in.hasNext() && !errorFSM){
			transitions = new ArrayList<String>();
			temp = in.nextLine();
			numLinea++;
			modifiers = null;
			p = Pattern.compile("("+myalphabet+")");
			m = p.matcher(temp);
			//This gets the current state
			//we are gonna use an index type to make sure we go back if we find the modifiers
			//CHECK currentState's LAST 2 CHARACTERS TO SEARCH FOR ! OR $ OR BOTH
			if(m.find()){
				currentState = m.group(1);

				if(currentState.endsWith("$!") || currentState.endsWith("!$")) {
					modifiers = currentState.substring(currentState.length()-2);
					currentState = currentState.substring(0,currentState.length()-2);
					acceptingStateExists = true;
				}else if(currentState.endsWith("!")){
					modifiers = "!";
					currentState = currentState.substring(0,currentState.length()-1);
				}else if(currentState.endsWith("$")){
					modifiers = "$";
					acceptingStateExists = true;
					currentState = currentState.substring(0,currentState.length()-1);
				}

				//System.out.println(m.group(1));
				//check if we have already seen this state, mainly for start state
				if(!findState(currentState)){
					alreadyInitializedStates.add(new MyNode(currentState));
					findState(currentState);//to set found to newly created node
				}	
			}
		}
	}
