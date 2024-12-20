/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  
	public static boolean isPunctuation(String str) {
		if (str == null || str.isEmpty()) {
			return false; 
		}
		String punctuationMarks = " .,:;!?\"'()-{}[]<>";
		char ch = str.charAt(0); 
		return punctuationMarks.indexOf(ch) != -1 ; 
	}	
	public static boolean isSame(String str1, String str2){
		return str1.equals(str2.toLowerCase()) || str1.equals(str2.toUpperCase());
	}
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false; 
		}
		if (str1.isEmpty() && str2.isEmpty()){
			return true;
		}
		String[] string1 = str1.split("");
		int l1 = str1.length();
		int l2 = str2.length();
		String[] string2 = str2.split("");
		int i=0,j=0;
		boolean find=false;
			for(i=0; i<l1 ;i++){
				if(!isPunctuation(string1[i])){
					find=false;
					for(j=0; j< l2 && !find; j++) {
						if(!isPunctuation(string2[j])){
							if(isSame(string1[i], string2[j])){
								find=true;
								string2[j]="";
							}
						}
					}
					if(!find){
						return false;
					}
				}
			}
		for (j=0; j<l2 ; j++){
			if(!string2[j].equals("")&& !isPunctuation(string2[j])){
				return false;
			}

		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String[] string1 = str.split("");
		if (str == null || str.isEmpty()) return str;
		String[] string2 = new String[string1.length];
		String result="";
		int i,j=0;
		for(i=0; i<string1.length; i++){
			if(!isPunctuation(string1[i])){
				string2[j]=string1[i].toLowerCase();
				j++;
			}
			if(string1[i].equals(" ")){
				string2[j]=string1[i];
				j++;
			}
		}
		for(i=0; i<string2.length && string2[i]!=null; i++){
			result+=string2[i];
		}
		return result; 
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String[] str1 = str.split("");
		String[] str2 = new String[str1.length];
		String result="";
		int random,i;
		for (i = 0; i < str1.length; i++) {
			str2[i] = null;
		}
		boolean isEmpty=false;
		for (i=0; i<str1.length; i++){
				isEmpty=false;
				while(!isEmpty){
				random = (int) (Math.random() * str1.length);
				if(str2[random]==null){
					str2[random]=str1[i];
					isEmpty=true;
				}
			}
		}
		for(i=0; i<str2.length ; i++){
			result+=str2[i];
		}
		return result; 
	}
}
