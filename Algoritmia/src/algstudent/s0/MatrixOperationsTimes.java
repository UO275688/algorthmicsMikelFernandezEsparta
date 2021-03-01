package algstudent.s0;

public class MatrixOperationsTimes {
	
	static int matrix[][];

	public static void main(String arg []){

		int nTimes = (int) (Integer.parseInt(arg[0]));
		
		for(int i = 10; i <= 1771470; i *= 3) { 
			matrix = new int[i][i];
			MatrixOperations.fillIn(matrix);
			
			long start = System.currentTimeMillis();
			  for(int j = 0; j < nTimes; j++) {			  
				  //MatrixOperations.sumDiagonal1(matrix);
				  MatrixOperations.sumDiagonal2(matrix);		  
			  }	
			  long end = System.currentTimeMillis();	
			  long t = (end - start);
			  float time = (float) t/nTimes;
			  System.out.println("The time taken to execute "+  i + " was " + time + " milliseconds");
		}			
	} 
}
