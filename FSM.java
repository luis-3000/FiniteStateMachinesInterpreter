//Miguel Azurin
//Jose Luis Castillo

import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import java.util.ArrayList;

public class FSM {

	private static boolean verbose = false;
	private static boolean warnings = false;
	private static boolean utTrap = false;		//unspecifiedTransitionsTrap
	private static boolean run = true;
	

	public static void main(String[] args) throws IOException{
		
		//Make sure at least one argument is entered, otherwise error
		if (args.length == 0) {
			System.out.println("You must define parameters in order to run this program. Pleas try again.");			
		}
		
		ArrayList<String> fsmFiles = new ArrayList<String>();
		ArrayList<String> userInputFiles = new ArrayList<String>();
		
		//Parse Arguments
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("--fsm")){
				i++;
				while(i<args.length && args[i].endsWith(".fsm")){
					fsmFiles.add(args[i]);		//stores ONLY the references to the String objects in fsmFiles
					i++;
				}
				i--;
				System.out.println("Do we have any .fsm files? " + fsmFiles.toString());
				
			}else if(args[i].equals("--input")){
				i++;
				while(i<args.length && args[i].endsWith(".txt")){
					userInputFiles.add(args[i]);
					i++;
				}
				i--;
				System.out.println("Do we have any .txt files? " + userInputFiles.toString());
				
			}else if(args[i].equals("--verbose")){
				verbose = true;
				//Options.verboseFunc(fsmFiles, userInputFiles, verbose);
				//System.out.println("inside --verbose " + verbose); //for debugging
			}else if(args[i].equals("--warnings")){
				warnings = true;
				//Options.warningsFunc(fsmFiles, userInputFiles);
				//System.out.println("inside --warnings " + warnings);  //for debugging
			}else if(args[i].equals("--unspecified-transitions-trap")){
				utTrap = true;
				//Options.unSpecTranTrapFunc(fsmFiles, userInputFiles);
				//System.out.println("--unspecified-transitions-trap " + utTrap);	//for debugging
			}else{
				System.out.println("Something is off with that command: Not running");
				run = false;
				break;
			}
		
		}
		
		//Run simulations
		
			System.out.println("All menu options checked. Moving on to runSimulation()");
			
			Machine.runSimulation(fsmFiles, userInputFiles, verbose, warnings, utTrap);
		
		

	}//end of main() class		

	
} //end of FSM class