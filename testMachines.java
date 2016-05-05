import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class testMachines {


	public static void main(String[] args) {

		// EACH MACHINE HAS TO BE TESTED SEPARATELY

		//sampleMachine		
//		Pattern p = Pattern.compile("a*b*");
//		System.out.println("Does patter " + p.toString() + " match to " + "aaaaab" + "?");
//		Matcher m = p.matcher("aaaaab");		
		
//		Pattern p = Pattern.compile("(a*)b*");
//		System.out.println("Does patter " + p.toString() + " match to " + "aaabbb" + "?");
//		Matcher m = p.matcher("aaabbb");
//		
//		System.out.println(m.matches());
//		System.out.print("done");
		
		/*
		 	nul	 null byte	 		\0
			bs	 backspace			\b
			ht	 horizontal tab	 	\t
			np	 formfeed	 		\f
			nl	 newline	 		\n
			cr	 carriage return	\r
		 */
		
		//machine1     (0{1})|(|n{1}|d*)
		//String inputAlphabet = "(0{1})|([1-9]{1}[0-9]*)";
		String inputAlphabet = "[0-9]*"; 											// |d
		Pattern p = Pattern.compile(inputAlphabet);
		Matcher m = p.matcher("0");
		//Matcher m = p.matcher("1");
		//Matcher m = p.matcher("1234");
		//Matcher m = p.matcher("107389743");
		//Matcher m = p.matcher("0, 0,1,2,3,4,5,6,7,8,9, 234324");	//
		//Matcher m = p.matcher("living la vida loca");		//
		//Matcher m = p.matcher("&*^*&(^");					//

		System.out.println(m.matches());
		System.out.print("done");
		
	
		
//		//machine2     (0{1})|(|n[1-3])|(|n[1-3],{1}|d)
//		//1,000 2,000,000 3,000,000,000  4,000,000,000,000
//		String inputAlphabet = "(0{1})|([1-9]{1,3})|([1-9]{1,3}(,{1}[0-9]{3})+)";     // |d
//		Pattern p = Pattern.compile(inputAlphabet);
//		//Matcher m = p.matcher("0");
//		//Matcher m = p.matcher("01");	//should be rejected
//		Matcher m = p.matcher("999");
//		//Matcher m = p.matcher("1,000");
//		//Matcher m = p.matcher("1,000,234,987,985");
//		//Matcher m = p.matcher("&*^*&(^");		//should fail
//
//		System.out.println(m.matches());
//		System.out.print("done");
		
		
//		//machine3     (0{1})|(+?|-?(|n{1}|d*))
//		String inputAlphabet = "(0{1})|([+]?[-]?[1-9]{1}[0-9]*)";	//[+]?|[-]?NOT WORKING FOR STUPID JAVA!! 
																					//// |d+-
//		Pattern p = Pattern.compile(inputAlphabet);
//		//Matcher m = p.matcher("0");
//		//Matcher m = p.matcher("4");
//		//Matcher m = p.matcher("+4");
//		//Matcher m = p.matcher("+45");
//		//Matcher m = p.matcher("-45");
//		//Matcher m = p.matcher("+0");		//should be rejected
//		//Matcher m = p.matcher("45.5");	//should be rejected
//		//Matcher m = p.matcher("0.3");		//should be rejected
//		Matcher m = p.matcher("&*^*&(^");	//should be rejected
//		
//		System.out.println(m.matches());
//		System.out.print("done");
		
		
		//machine4     [a-zsymbols|A-Zsymbols]*olivia[a-z|A-Z]*
//		String inputAlphabet = "^[a-zA-Z0-9!@#%/&*-+{}().,]*olivia[a-zA-Z0-9!@#%/&*-+{}().,]*$";
//		Pattern p = Pattern.compile(inputAlphabet);
//		//Matcher m = p.matcher("OolioliviablAh1");
//		//Matcher m = p.matcher("olivia");
//		//Matcher m = p.matcher("blaholiviablah");
//		//Matcher m = p.matcher("olivias");
//		//Matcher m = p.matcher("solivia");
//		//Matcher m = p.matcher("olivias");	
//		//Matcher m = p.matcher("solivas"); 	//should be rejected
//		//Matcher m = p.matcher("+45");		 //should be rejected
//		Matcher m = p.matcher("&*^*&(^");	 //should be rejected
//		
//		System.out.println(m.matches());
//		System.out.print("done");	
		
		
//		//machine5     (0{1}.{1}|d*)|(|n.{1}|d*)
//		String inputAlphabet = "(0{1}.{1}[0-9]+)|([1-9][0-9]*.{1}[0-9]+)";
//		Pattern p = Pattern.compile(inputAlphabet);
//		//Matcher m = p.matcher("0.003");
//		//Matcher m = p.matcher("0.20");
//		//Matcher m = p.matcher("0.000");
//		//Matcher m = p.matcher("3.54");
//		Matcher m = p.matcher("10.02");
//		//Matcher m = p.matcher("0..0300");		//should be rejected
//		//Matcher m = p.matcher("1.");			//should be rejected
//		//Matcher m = p.matcher("55");			//should be rejected
//		//Matcher m = p.matcher("01.33");		//should be rejected
//		//Matcher m = p.matcher("+0.003");
//		//Matcher m = p.matcher("&*^*&(^");		//should be rejected	
//
//		System.out.println(m.matches());
//		System.out.print("done");		
		
						
//		//machine6     (.(.).)  | (.(.(.).).)   | (.(.(.(.).).).)
////		String inputAlphabet = "([^()]*[(]{1}[^()]*[)]{1}[^()]*)|([^()]*[(]{1}[^()]*[(]{1}[^()]*[)]{1}[^()]*[)]{1}[^()]*)|([^()]*[(]{1}[^()]*[(]{1}[^()]*[(]{1}[^()]*[)]{1}[^()]*[)]{1}[^()]*[)]{1}[^()]*)";
//		String inputAlphabet = "(^[a-zA-Z0-9!@#%/&*-+{}().,]*[(]{1}[^()]*[)]{1}[^()]*)|([^()]*[(]{1}[^()]*[(]{1}[^()]*[)]{1}[^()]*[)]{1}[^()]*)|([^()]*[(]{1}[^()]*[(]{1}[^()]*[(]{1}[^()]*[)]{1}[^()]*[)]{1}[^()]*[)]{1}[a-zA-Z0-9!@#%/&*-+{}().,]*$)";
//		Pattern p = Pattern.compile(inputAlphabet);
//		//Matcher m = p.matcher("()");
//		//\Matcher m = p.matcher("(())");
//		//Matcher m = p.matcher("((()))");
//		//Matcher m = p.matcher("r(s)t");
//		//Matcher m = p.matcher("a(b(c)d)e");
//		//Matcher m = p.matcher("a(b(c(d)e)f)g");
//		//Matcher m = p.matcher("");			//should be rejected
//		//Matcher m = p.matcher("rest");		//should be rejected
//		//Matcher m = p.matcher("(((())))");	//should be rejected 
//		//Matcher m = p.matcher("01.33");		//should be rejected
//		//Matcher m = p.matcher("&*^*&(^");		//should be rejected	
//
//		System.out.println(m.matches());
//		System.out.print("done");	
//		
		
		
//		//machine7    (9[8-0])|(8[7-0])|(7[6-0])|(6[5-0])|(5[4-0])|(4[3-0])|(3[2-0])|(2[1-0])|(1[0])|0
//		//String inputAlphabet = "(9876543210)|(876543210)|(76543210)|(6543210)|(543210)|(43210)|(3210)|(210)|(10)|0";//NOT WORKING!
//		String inputAlphabet = "(9[8-0])|(8[7-0])|(7[6-0])|(6[5-0])|(5[4-0])|(4[3-0])|(3[2-0])|(2[1-0])|(1[0])|0";
//		Pattern p = Pattern.compile(inputAlphabet);
//		Matcher m = p.matcher("90");
//		//Matcher m = p.matcher("52");
//		//Matcher m = p.matcher("09");   //should be rejected
//		//Matcher m = p.matcher("25");	//should be rejected
//		//Matcher m = p.matcher("+25");	//should be rejected
//		//Matcher m = p.matcher("-65");	//should be rejected
//		//Matcher m = p.matcher("a(b(c)d)e"); //should be rejected
//		//Matcher m = p.matcher("");		//should be rejected
//		//Matcher m = p.matcher("rest");			//should be rejected
//		//Matcher m = p.matcher("(((())))");			//should be rejected NOT BEING REJECTED! WITH DEF 1
//		//Matcher m = p.matcher("01.33");		//should be rejected
//		//Matcher m = p.matcher("&*^*&(^");		//should be rejected	
//
//		System.out.println(m.matches());
//		System.out.print("done");			

	}

}