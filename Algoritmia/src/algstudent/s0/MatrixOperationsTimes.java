package algstudent.s0;

import algstudent.s1.Vector1;

public class MatrixOperationsTimes {
	
	final static int MIN_DIMENSION = 2;
	static int[] v;
	int matrix[][];
	//private List<Integer> values = new ArrayList<>();

	public static void main(String arg []){
		int n = Integer.parseInt(arg[0]); //Size of the problem in the first argument
		v = new int[n];
		Vector1.fillIn(v);
		long start = System.currentTimeMillis();
		Vector1.sum(v);
		long end = System.currentTimeMillis();
		 
		System.out.println("The time taken to execute " + n + " repetitions was " + (end - start) + " milliseconds");
	} 
}
