package org.memoryextension.piglatin;

public class PigLatin {
	
	public static final String AY = "ay";
	public static final String WAY = "way";
	
	static boolean isVowel(char ch){
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' );
	}
	
	static String convert(String string) {
		if(string==null){return "";} /* if string is null, we return "" as the pig latin */
		
		String regex = "[,\\.\\s]";
		String[] stringArray = string.split(regex);
		
		String pl_Version= "";
		
		for (String s : stringArray) {
			char firstLetter=s.charAt(0);
			char secondLetter=s.charAt(1);
			
			if(!isVowel(firstLetter)) { /* check if first letter not a vowel */
				if(isVowel(secondLetter)){ /* check if second letter a vowel */
					pl_Version+=s.substring(1)+firstLetter+AY+" "; // TODO StringBuilder ?
				}
				if(!isVowel(secondLetter)){
					pl_Version+=s.substring(2)+firstLetter+secondLetter+AY+" ";
				}
			}
			if(isVowel(firstLetter)) {
				pl_Version+=s+WAY+" ";
			}
		}
		/* return the pig latin version*/
		return pl_Version;
	}
}
