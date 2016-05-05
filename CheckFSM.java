import java.io.FileInputStream;
import java.io.IOException;


public class CheckFSM {
	private static State [] collection; // array of states
    private static int stateCount;
    private static int startState; // index of starting state
    private static int currentState; // index of current state (initialized to startState), "0" if machine has failed
    private static boolean isAlive;
   
    public static void Machine(String infile) throws IOException {
    		int MAX_STATE_COUNT = 20;
    		collection = new State[MAX_STATE_COUNT];
	    	Alphabet A = new Alphabet();
	        isAlive = true;
	        String [] allStateNames = new String[MAX_STATE_COUNT]; // names of all states found in the machine file
	        allStateNames[0] = ""; 
	        stateCount = 0; // total number of states in current machine   
	        int n = 0; // for reading input from file
	        char input = 0;
	        
	        // Each line specifies one state   
	        String stateName = ""; // will hold name of current state, as is it on one line in file
	        boolean types[] = {false, false, false}; // presence or lack of "$", "!" and respectively
	        int curState = 0; // index assigned to the current working state

	        // Within each line there are multiple transition states
	        String transName = ""; // name of current working transition state
	        int curTrans = 0; // index assigned to the current working transition state
		
	        // int [] transNameInds = new Int[MAX_STATE_COUNT]; // indices of states that the current state will transition to
	        int [] alphTrans = new int[A.alphSize()]; // array of alphabet chars, each storing the state a char will transition to
	        for (int i = 0; i < A.alphSize(); i++)
	            alphTrans[i] = 0;

	        // Controls for stages of file reading
	        boolean isNameStage = true; //  reads the state name (when true); reads the transitions (when false)
	        boolean readTransName = true; // reads the transition states (when true); reads the strings that cause transition (when false)
	        boolean readPipeChar = false; // if last char read was a pipe (when true), the next char will be a shortcut reference
			//boolean gotaspace = false;

	        // DEFINE nameInd
	   
	        // Load machinefile
	        FileInputStream machine = new FileInputStream(infile);
	        while ((n = machine.read()) != -1) { // while not EOF
	            input = (char)n;
	            //System.out.println(input);
	            // NAME STAGE
	            if (isNameStage == true) {
	                switch(input) {           
	                    case '$': types[0] = true; break;
	                    case '!': types[1] = true; break;
	                    case '@': types[2] = true; startState = stateCount + 1; break;
	                    case ' ':
	                    //System.out.println("inp " + input + " " + readTransName);
	                    if(stateName.equals("") == false) {
	                    //allStateNames[stateCount] = stateName;
	                    	curState = -1;
	                        for (int i = 0; i < stateCount+1; i++) {
	                        	    if(allStateNames[i].equals(stateName)) curState = i;
	                        }
	                        if (curState == -1) {
	                        	stateCount++;
	                        	allStateNames[stateCount] = stateName;
	                        	curState = stateCount;
	                        }
	                        stateName = "";
	                        isNameStage = false;
	                    }
	                    break;
	                    case '\n':
	                    curState = -1;
	                    for (int i = 0; i < stateCount+1; i++) {
	                    	if(allStateNames[i].equals(stateName)) {
	                    		curState = i;
	                    	}	
	                    }
	                    types[0] = false; types[1] = false; types[2] = false;
	                    for (int i = 0; i < A.alphSize(); i++) {
	                            alphTrans[i] = 0;
	                	}
	                    break;
	                    default:
	                        //if (alphIndex(input) != -1)
	                        stateName = stateName + input;
	                        //else System.out.println("1:Invalid char: " + input + " in machine specification.");
	                    break;
	                }
	            }

	            // STATE STAGE
	            else if (isNameStage == false) { 
	                // "NAME OF TRANSITION STATE" STAGE
	            	if (readTransName == true) {
	            		switch(input) {
	            			case ' ':
	            				break;
	            			case '\n':
	            				isNameStage = true;
	            				readTransName = true;
	                            if (types[1] == false) {
	                                collection[curState] = new State(curState, types, alphTrans);
	            				} else {
	            					for (int i = 0; i < A.alphSize(); i++) {//Need to add alphabet index to the program. added to alphabet
	                                    alphTrans[i] = curState;
	            					}
	            					collection[curState] = new State(curState, types, alphTrans);
	                            }
	                            types[0] = false; 
	                            types[1] = false; 
	                            types[2] = false;
	                            for (int i = 0; i < A.alphSize(); i++) {//Need to add alphabet index to the program. added to alphabet
	                                alphTrans[i] = 0;
	            				}
	                            break;
	                        case ':':
	                            curTrans = -1;
	                            for (int i = 0; i < stateCount+1; i++) {
	                                if(allStateNames[i].equals(transName)) curTrans = i;
	                            }
	                            if (curTrans == -1) {
	                                stateCount++;
	                                allStateNames[stateCount] = transName;
	                                curTrans = stateCount;
	                            }
	                            transName = "";
	                            readTransName = false;
	                            break;
	                        default: //Need to add alphabet index to the program. added to alphabet
	                            if (A.alphIndex(input) != -1) {
	                                transName = transName + input;
	            				}
	                            else {
	                            	System.out.println("2:Invalid char: " + input + " in machine specification.");
	                            }
	                            break;
	                    }
	                }
	   
	                // "STRING TO TRANSITION UPON" STAGE
	                else if (readTransName == false) {
	                	switch(input) {
	                    	case ' ':
	                    		readTransName = true;
	                    		transName = "";
	                            break;
	                        case '\n':
	                            isNameStage = true;
	                            readTransName = true;
	                            if (types[1] == false) {
	                            	collection[curState] = new State(curState, types, alphTrans);
	                            }
	                            else {
	                                for (int i = 0; i < A.alphSize(); i++) {
	                                    alphTrans[i] = curState;
	                                }    
	                                collection[curState] = new State(curState, types, alphTrans);
	                            }
	                            types[0] = false; 
	                            types[1] = false; 
	                            types[2] = false;
	                            for (int i = 0; i < A.alphSize(); i++) {
	                                alphTrans[i] = 0;
	                            }    
	                            break;
	                        case '|':
	                            readPipeChar = true; 
	                            break;
	                        default:
	                            if (A.alphIndex(input) != -1) {
	                                if (readPipeChar == true) {
	                                    String shortcut = "";
	                                    shortcut = A.translatePipe(input);
	                                    for(int i = 0; i < shortcut.length(); i++) {
	                                        alphTrans[A.alphIndex(shortcut.charAt(i))] = curTrans;
	                                    }
	                                    readPipeChar = false;
	                                }
	                                else {
	                                    alphTrans[A.alphIndex(input)] = curTrans;
	                                }    
	                            }
	                            else {
	                            	System.out.println("Invalid char " + input + " in machine specification.");
	                            }
	                            break;
	                    }
	                }              
	            }
	        } 
    
   	if(startState == 0) 
		System.out.println("Error: No start state found.");
        currentState = startState;
    } 
    
    void nextTransition(char input) {// transition from current state, return new state
    	Alphabet A = new Alphabet();
        if(isAlive == true) {   
            int ain = A.alphIndex(input);
		    System.out.println(ain + " " + currentState);
            if (ain != -1) {
                currentState = collection[currentState].transTo[ain];
                //System.out.println("currentState: " + currentState);
            }
            if (currentState == 0 || ain == -1) isAlive = false;
        }
    }

    boolean alive() { // return if machine has failed permanently
        return isAlive;
    }

    // Machine isAccepting if isAlive and the current state of our collection is still accepting 
    boolean isAccepting() {
    	return (isAlive && collection[currentState].isAccepting);
    }
    
  
    
    void reset() {
        currentState = startState;
        isAlive = true;
    }

}
