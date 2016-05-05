import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class RunOneMachine {
	
	public static void runOnce(File fsmFile, File userInputFile, boolean verbose, boolean warnings, boolean utTrap) throws IOException{
		
		boolean isAccepted = true;

//		BufferedReader newFile = new BufferedReader(new FileReader(fsmFile));
//		BufferedReader newFile2 = new BufferedReader(new FileReader(userInputFile));
		
		Scanner scan1 = new Scanner(userInputFile);	//Grab one line from user file, run it through One machine
		Scanner scan2 = new Scanner(fsmFile);
		
		//I think we should check if this fsmFile is valid before we even use it
		boolean goodFSMFile = isValidFile(fsmFile);
		
		
		while(scan1.hasNextLine()){			//Read ONE fsmLine at a time
			String lineX = scan1.nextLine(); //Advances this scanner past the current line and returns the input that was skipped
			//Should we check if fsmLine is valid before we continue?
			//isValidFsmLine(lineX);

			while(scan2.hasNextLine()){		//Read ONE userFileLine at a time
				//Now on this line we need to read tokens to check for inputStringName, : , inputStringToProcess

				String[] inLine = new String[3];

				while(scan2.hasNext()){
					String token = scan2.next();	//save this token (string)					
					if(token!=" " || token!=":"){	//try store stringName
						inLine[0] = token;
					}else if(token == ":"){
						inLine[1] = token;
					}
					else if(token!=" " || token != ":"){
						inLine[2] = token;
					}
					else{
						System.out.println("Invalid userInputString line");
					}

				}

			}			
		}		
	
//		while(false){
//			if (!newFile.ready()) {
//				isAccepted = false;
//				break;
//			}
//			String fullstring = newFile.readLine();
//		    //at the end of string; check if string was accepted
//		    if (isAccepted   == true) System.out.println(userInputFile + " Accepted:  " + fullstring);
//		    else System.out.println(userInputFile + " Rejected:  " + fullstring);
//		    fullstring = ""; //reset fullstring for next transmition
//			}
		
		} //end of runOnce()

}//end of RunOneMachine class
