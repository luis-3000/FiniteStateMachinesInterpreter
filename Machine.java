import java.io.*;
import java.util.*;


public class Machine {    
	/*
	 * Runs the simulation for each machine?
	 */
	public static void runSimulation(ArrayList<String> machineFiles, ArrayList<String> userFiles, 
			boolean verbose, boolean warnings, boolean utTrap) throws IOException{

		System.out.println("I am inside runSimulation()");

		Integer g1Lenght = machineFiles.size();		//Group 1, fsm machine names
		Integer g2Lenght = machineFiles.size();		//Group 2, userInputFile names

		//If machineFiles is an empty group
		if(g1Lenght==0){
			System.out.println("There are no fsm machines to run");
			return;
		}

		int i = 0;
		while(i<g1Lenght){				//while we have fsmFiles
			//System.out.println("inside i<g1Lenght");
			int  j = 0;
			while(j<g2Lenght){			//while we still have userInputFiles
				//System.out.println("inside j<g2Lenght");

				File txtFile = new File(machineFiles.get(i));		//get indicated .fsm file
				File fsmFile = new File(userFiles.get(j));			//get indicated .txt file
				System.out.println("inside j<g2Lenght, Reading 2 groups: " + machineFiles + " " + userFiles);

				//Run this .txt file on this .fsm file
				RunOneMachine.runOnce(txtFile, fsmFile, verbose, warnings, utTrap);

				j++;
			}
			i++;
		} 

	}//runSimulation()


}//End of Machine class


