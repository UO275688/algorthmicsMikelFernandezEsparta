/*
JAVA is sensitive to upper and lower case.
A class should begin with a capital letter.
Methods and all kinds of variables should begin with lower case.
 
Java classes are stored in files with the same as the class, 
(to which we add the .java extension). Vector1.java in this case.

Packages must be in a directory path with the same name, that is,
package alg77777777.s1 should be in the directory alg77777777/s1.
*/
package algstudent.s1;

/**
 * This program is for working with vectors and see how Java programs work
 */
public class Vector4 {
	static int[] v; //Vector of elements
	public Vector1 v1 = new Vector1();
	
	public static void main(String arg []){
	  int n_max = (int) (Integer.parseInt(arg[0]));
	  int nTimes = (int) (Integer.parseInt(arg[1]));
	  
	  for(int i = 10; i <= n_max; i *= 3) {
		  v = new int[i];
		  Vector1.fillIn(v);
		  int[] m = new int[12];
		  long start = System.currentTimeMillis();
		  for(int j = 0; j < nTimes; j++) {			  
			  Vector1.maximum(v, m);			  
		  }	
		  long end = System.currentTimeMillis();	
		  long t = (end - start);
		  float time = (float)t/nTimes;
		  System.out.println("The time taken to execute "+  i + " was " + time + " milliseconds");
	  }	  
	} 
}
