package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
	private static boolean isVowel (char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
	}
   public static String go( String a )
	{
	   String low = a.toLowerCase();
	   char head = low.charAt(0);
	   char tail = low.charAt(low.length()-1);
	 
		return (isVowel(head) || isVowel(tail)) ? "yes" : "no";
		
	}
}