import java.util.ArrayList;


public class Debug {	
	
	/*------------------------------------------------------------------------------------------------------------------
	 * Methods that print the FSM warnings
	 ------------------------------------------------------------------------------------------------------------------*/

	/*
	 * This is called if the user does not specify a transition for every value in the language, the program should 
	 * alert the user that the state has an incomplete transition table.
	 */
	public static void IncompleteTransitionTable (String fsm_name, String state_name){
		System.out.println("FSM WARNING: " + fsm_name + " : INCOMPLETE TRANSITION TABLE FOR STATE " + state_name);
	}
	
	/*
	 * This is called if there is no accepting state for any current state
	 */
	public static void MissingAcceptingState (String FSMfileName){
		System.out.println("FSM WARNING: " + FSMfileName + ": MISSING ACCEPTING STATE");
		
	}
	
	/*
	 * This is called if we cannot connect a CurrentState with a NextState
	 */
	public static void UnconnectedComponents (String FSMfileName){
		System.out.println("FSM WARNING: " + FSMfileName + ": UNCONNECTED COMPONENTS");
	}
	
	/*
	 * Called if the alphabet is of incorrect type
	 */
	public static void UnsupportedAlphabet (String fsm_name, int input_line_name){		//Per Patric Yost
		System.out.println("FSM WARNING: " + fsm_name + ": UNSUPPORTED ALPHABET FOR " + input_line_name);		
	}

	
	/*------------------------------------------------------------------------------------------------------------------
	 * Methods that print FSM file errors. Need 7 methods for each of these 7 messages
	 ------------------------------------------------------------------------------------------------------------------*/	
	
	/*
	 * This method called when the Starting state is missing
	 */
	public static void nameOfStartStateMissing (String fsm_name, String name_of_parameter){
	//Starting state is missing when you don't say anything about the Start State
	System.out.println("FSM FILE ERROR: " + fsm_name + ": " + name_of_parameter + " IS MISSING");
	}												//Here name_of_parameter is the Starting State (usually S1)
	
	public static void invalidValueOfParameter (String fsm_name, String name_of_parameter, String value_of_parameter ){
	System.out.println("FSM FILE ERROR: " + fsm_name + ": " + name_of_parameter + " HAS INVALID VALUE " + value_of_parameter);	
	}
	
	public static void invalidTransitionOnState (String fsm_name, int line_number ){
	System.out.println("FSM FILE ERROR: " + fsm_name + ": INVALID TRANSITION FOR  MORE MACHINE ON LINE " + line_number);
	}
	
	public static void invalidTransitionSymbol (String fsm_name, int line_number){
	System.out.println("FSM FILE ERROR: " + fsm_name + ": INVALID TRANSITION SYMBOL ON LINE " + line_number);
	}
	
	public static void invalidOutputSymbol (String fsm_name, int line_number){
	System.out.println("FSM FILE ERROR: " + fsm_name + ": INVALID OUTPUT SYMBOL ON LINE " + line_number);
	}
	
	public static void multipleTransitionsOnSameSymbol (String fsm_name, String state_name){
	System.out.println("FSM FILE ERROR: " + fsm_name + ": NON-DETERMINISTIC TRANSITION TABLE FOR STATE " + state_name);
	}
	
	//it's invalidly formatted when you do say "START_STATE" but the parser can't figure out anything useful past that.
	public static void InvalidFormattingOnFSMLineNum (String fsm_name, int line_number){
	System.out.println("FSM FILE ERROR: " + fsm_name + ": INVALID FORMATTING ON LINE " + line_number);
	}
	
	
	
	/*------------------------------------------------------------------------------------------------------------------
	 * Methods that print user file input errors
	 ------------------------------------------------------------------------------------------------------------------*/	
	public static void multipleStringOnThisInputLine (String input_name, int line_number){
	System.out.println("INPUT FILE ERROR: " + input_name + ": MULTIPLE STRINGS ON LINE " + line_number);
	}
	
	public static void missingInputStringNameInputFile (String input_name, String input_file_name){
	//Well, thinking about it now. You can have multiple input files... so probably the file name would be best.
			//Patric Yost: This is a typo. For this error, use the file name.
	System.out.println("INPUT FILE ERROR: " + input_name + ": MISSING NAME ON FILE: " + input_file_name);
	}
	
	public static void missingInputStringInputFile (String input_name, int line_number){
	System.out.println("INPUT FILE ERROR: " + input_name + " MISSING INPUT STRING ON LINE " + line_number + ".");
	}
	
	
	/*------------------------------------------------------------------------------------------------------------------
	 * Methods that display whether input has been accepted or rejected, and transitions trace for each state
	 ------------------------------------------------------------------------------------------------------------------*/
	
	public static void stepTrace(String step, String currentState, String symbol, String next_state){
		System.out.println(step + " : " + currentState + " -- " + symbol + " --> " + next_state);
	}
	
	public static void inputAccepted(String machineName, String userInputString){
		//Once run on a machine, if user input string is accepted
		System.out.println(machineName + " : " + "ACCEPTS " + userInputString);
	}
		
	public static void inputRejected(String machineName, String userInputString){
		//else print its been rejected
		System.out.println(machineName + " : " + "REJECTS " + userInputString);
	}
	
	
	public static void inputOutput(String machine_name, String input, String output){
		System.out.println(machine_name + " : " + input + " / " + output);
	}

}
