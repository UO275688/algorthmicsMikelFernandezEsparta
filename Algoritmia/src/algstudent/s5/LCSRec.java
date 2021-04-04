package algstudent.s5;

import java.util.Random;

public class LCSRec {
	
	/**
	 * Generates a random sequence
	 * @param n sequence size
	 * @return random sequence, sting of characters
	 */
	public String genRandomSeq(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Find a MSC directly by a recursive approach 
	 */
	/*public String findLongestSubseq(String s1, String s2){
		if(s1.length() == 0 || s2.length() == 0) {
			return "";
		}
		String result = "";
		
		String s1prime = s1.substring(0, s1.length() - 1);
		String s2prime = s2.substring(0, s2.length() - 1);	
	    
		result += findLongestSubseq(s1prime, s2); //L1
		result += findLongestSubseq(s1, s2prime); //L2
		result += findLongestSubseq(s1prime, s2prime); //L3
		
		char s1rightmost = s1.charAt(s1.length() - 1);
		char s2rightmost = s2.charAt(s2.length() - 1);
		
		if(s1rightmost == s2rightmost) {
			result += 1;
		}
		
		return result;
	}*/
	
	public String findLongestSubseq(String s1, String s2){
		if(s1.length() == 0 || s2.length() == 0) {
			return "";
		}
		String result = "";
		
		String s1prime = s1.substring(0, s1.length() - 1);
		String s2prime = s2.substring(0, s2.length() - 1);	
	    
		String L1 = findLongestSubseq(s1prime, s2); 
		String L2 = findLongestSubseq(s1, s2prime); 
		String L3 = findLongestSubseq(s1prime, s2prime); 
		
		char s1rightmost = s1.charAt(s1.length() - 1);
		char s2rightmost = s2.charAt(s2.length() - 1);
		String h1 = s1.substring(s1.length()-1, s1.length());
        String h2 = s2.substring(s2.length()-1, s2.length());
        if (h1.equals(h2))
            L3 = L3.concat(h1); // L3 + 1
        
		result += max(L1,L2,L3, s1rightmost, s2rightmost);
		
		return result;
	}
	
	private String max(String l1, String l2, String l3, char s1rightmost, char s2rightmost) {
		if(l1.length() > l2.length() && l1.length() > l3.length()) {
			return l1;
		}
		if(l2.length() > l1.length() && l2.length() > l3.length()) {
			return l2;
		}
		String result = l3;
		
		/*if(s1rightmost == s2rightmost) {
			result += 1;
		}*/
		
		return result;
	}

	/**
	 * Get the index for the longest of three strings
	 * @param l1 e.g. input L1=MSC(S1’, S2). S1’ S1 without its last char
	 * @param l2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param l3 e.g. input L3=MSC(S1’, S2’) or L3+1 when both current chars are equal
	 * @return index of the longest string
	 */
	@SuppressWarnings("unused")
	private int longest(String l1, String l2, String l3) {
		return -1;
		// TODO (optional): from three different sequences (e.g. subsequences) gets index for the longest
	}
}
