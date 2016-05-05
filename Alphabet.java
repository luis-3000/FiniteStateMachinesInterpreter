

public class Alphabet { 
	//strings to hold contents of the alphabet
	private static String validInput = ""; //will hold lower + digits +symbols
	private static String symbols;
	private static String lower;
	private static String upper;
	private static String digits;
	private static String nonzerodigits;
	private static String alphabet;
    
    public static String getValidInput(){
    	return validInput;
    }

    public Alphabet() {
        lower = "abcdefghijklmnopqrstuvwxyz";
        upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = lower + upper;
        digits = "0123456789";
        nonzerodigits = "123456789"; 
        symbols = "!@#%/&*-+{}().,"; //any more?
        validInput = alphabet + digits + symbols; 
	}   

    //Alphabet validInput length 
    public int alphSize() {
    	return validInput.length();
    }

    //Alphabet index of a given character input
    public int alphIndex(char input) {
        return validInput.indexOf(input);
    }   
    
    //Alphabet character of a given integer input
    public char alphChar(int input) {
    	return validInput.charAt(input);
    }
    
    public String translatePipe(char type) {// given a shortcut, returns the full translated string
        switch(type){
        	case 'u':
        		return upper;
        	case 'l':
        		return lower;
            case 'a':
                return upper + lower; //upper case + lower case
            case 'd':
                return digits; 
            case 'n':
                return nonzerodigits;
            case 's':
                return symbols;
            default:
                System.out.println("Invalid shortcut.");
                return "";
            }
    }
    
}
