import java.util.ArrayList;


public class Options {
	
	//constructor? maybe
	
	/*
	 * Provide full trace of the simulation with all states
	 * So, we run each userInputFile and all of its string on each fsmFile
	 */
	public static void verboseFunc(ArrayList<String> machineFiles, ArrayList<String> userFiles){
		//System.out.println("We got to the verboseFunc()"); //For debux
		//Machine.runSimulation(machineFiles, userFiles);
	}

	/*
	 * Print warnings on the FSM files and user files
	 * We check for problems on both .fsm and .txt files
	 */
	public static void warningsFunc(ArrayList<String> machineFiles, ArrayList<String> userFiles){
		//System.out.println("We got to the warningsFunc()");
		Debug.warningsFunc(machineFiles, userFiles);
		
	}
	
	/*
	 * Print which unspecified transitions were encountered, if any
	 */
	public static void unSpecTranTrapFunc(ArrayList<String> machineFiles, ArrayList<String> userFiles){
		System.out.println("We got to the unSpecTranTrapFunc()");
	}
}
