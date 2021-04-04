package algstudent.s5;

import java.util.Random;

public class LCS {
	
	CellTable[][] table; //table with local values
	String str1; // 1st string
	String str2; // 2nd string
	String result; // result string
	int size1; //str1 size
	int size2; //str2 size
	char[] x;
	char[] y;
	int lengthLCS;
	
	/**
	 * Constructor
	 * @param s1 1st string to compare
	 * @param s2 2nd string to compare
	 */
	public LCS(String s1, String s2) {
		str1 = "*" + s1; //str1. 1st column is headed with asterisk
		str2 = "*" + s2; //str2. 1st row is headed with asterisk
		System.out.println("String1: " + str1);
		System.out.println("String2: " + str2);
		size1 = str1.length();
		size2 = str2.length();
		x = str1.toCharArray();
		y = str2.toCharArray();
		result = "";
		table = new CellTable[size1][size2]; // table used for dynamic programming 
	}
	
	/**
	 * Constructor used to measure times
	 * @param n size for the strings that are generated randomly 
	 */
	public LCS(int n) {
		str1 = "*" + this.genRandomSeq(n);
		str2 = "*" + this.genRandomSeq(n);
		size1 = str1.length();
		size2 = str2.length();
		result = "";
		table = new CellTable[size1][size2]; // table used for dynamic programming para guardar todos los valores de la tabla dinámica 
	}
	
	/**
	 * Generates a random sequence
	 * @param n sequence size
	 * @return random sequence, sting of characters
	 */
	private String genRandomSeq(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Table values initialization
	 */
	public void initTable() {
		for (int j=0; j<size2; j++)
			for(int i=0; i<size1; i++)
				table[i][j] = new CellTable();
	}
	
	
	/**
	 * Print the table with the results
	 */
	public void printTable() {
		System.out.printf("%11s", "*");
		for (int i=0; i<size1; i++) 
			System.out.printf("%11s", str1.substring(i, i+1)); // chars str1 (horizontal)
		System.out.println();
		
		for (int j=0; j<size2; j++) {
			System.out.printf("%11s", str2.substring(j, j+1)); // chars str2 (vertical)
			for(int i=0; i<size1; i++)
				System.out.printf("%4d(%2d,%2d)", table[i][j].value, table[i][j].iPrev, table[i][j].jPrev); // table values
			System.out.println();
		}
	}
	
	
	/**
	 * Print current MSC result
	 */
	public void printLongestSubseq(){
		System.out.println("Result: " + result);
	} 

	public class CellTable{
		public int value; // value for dynamic programming
		public int iPrev; //"pointer" to string 1 character used to compute value 
		public int jPrev; //"pointer" to string 2 character used to compute value
		
		public CellTable() {

		}
		
		public CellTable(int value) {
			this.value = value;
		}
		
		public CellTable(int value, int i, int j) {
			this.value = value;
			this.iPrev = i;
			this.jPrev = j;
		}
		
		public CellTable(CellTable cellTable) {
			value = cellTable.value;
		}
	}
	
	/**
	 * Fill table values for dynamic programming
	 */
	public void fillTable(){
		CellTable[][] L = new CellTable[size1+1][size2+1];

	    for (int i=0; i<=size1; i++){
	    	for (int j=0; j<=size2; j++){	      
	    		if (i == 0 || j == 0) {
	    			L[i][j] = new CellTable(0,0,0);
	    		}	            
	    		else if (x[i-1] == y[j-1]) {
	    			CellTable auxTable = new CellTable( L[i-1][j-1]);
	    			CellTable aux1 = new CellTable(1);
	    			int aux = auxTable.value + aux1.value;
		            L[i][j] = new CellTable(aux,i,j);
	    		}
	    		else {
	    			int aux = max(L[i-1][j], L[i][j-1]);
	    			L[i][j] = new CellTable(aux, i, j);
	    		}
	     	}
	    }
	    table = L;
	}
	
	/**
	 * Get the index for the maximum of three numbers
	 * @param num1 e.g. input L1=MSC(S1’, S2). S1’ S1 without its last char
	 * @param num2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param num3 e.g. input L3=MSC(S1’, S2’) or L3+1 when both current chars are equal
	 * @return index of maximum
	 */
	@SuppressWarnings("unused")
	private int longest(int num1, int num2, int num3) {
		return -1;
		// TODO (optional): from three different values (e.g. partial MSC lengths) gets index for the longest
	}
	
	/**
	 * Find the MSC from the table (dynamic programming)
	 * @param v if True verbose mode activated (To show the path trough the different cells)
	 */
	public void findLongestSubseq(boolean v){
		int L[][] = new int[size1+1][size2+1];

	    for (int i=0; i<=size1; i++){
	    	for (int j=0; j<=size2; j++){	      
	    		if (i == 0 || j == 0) {
	    			L[i][j] = 0;
	    		}	            
	    		else if (x[i-1] == y[j-1]) {
		            L[i][j] = L[i-1][j-1] + 1;
	    		}
	    		else {
		            L[i][j] = max(L[i-1][j], L[i][j-1]);

	    		}
	     	}
	    }
	    
	    //lengthLCS = L[size1][size2];	  
		int index = L[size1][size2];
		int aux = index;

		char[] lcs = new char[index + 1];
		lcs[index] = '\0';

		int i = size1;
		int j = size2;
		while (i > 0 && j > 0) {
			if (x[i - 1] == y[j - 1]) {
				lcs[index - 1] = x[i - 1];	
				i--;
				j--;
				index--;
			}
			else if (L[i - 1][j] > L[i][j - 1]) {
				i--;
			}	     
			else {
				j--;
			}
		}

		System.out.print("LCS: ");
		for (int k = 0; k <= aux; k++) {
			result += lcs[k];
			System.out.print(lcs[k]);
		}
		//System.out.println("Length: " + lengthLCS);
		System.out.println("");
	}
		
	private int max(int a, int b){
	    if (a > b) {
	    	return a;
	    }
	    return b;
	}
	
	private int max(CellTable l, CellTable l2){
	    if (l.value > l2.value) {
	    	return l.value;
	    }
	    return l2.value;
	}
}
