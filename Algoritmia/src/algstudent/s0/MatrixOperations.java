package algstudent.s0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixOperations {
	
	final static int MIN_DIMENSION = 2;
	
	int matrix[][];
	private List<Integer> values = new ArrayList<>();

	
	/**
     * Constructor for objects of class Matrix
     * 
     * @param int containing the value of the dimension 
     * @param int containing the value of the minimum value
     * @param int containing the value of the maximum value
     */
	public MatrixOperations(int dimension, int min, int max) {
		if (dimension < MIN_DIMENSION){    
			throw new IllegalArgumentException ("Error: dimension must be greater than 2");
	    }
		matrix = new int[dimension][dimension];
				
		Random value = new Random();
        
	    for (int i =0; i < matrix.length; i++){
	    	for (int j = 0; j < matrix[0].length; j++){
	    		matrix[i][j] = value.nextInt(max - min) + min;
	    	}
	    }
	}
	
	public MatrixOperations(String fileName) throws IOException {
		List<String> lines = new FileUtil().loadLines( fileName );
		List<Integer> value = new IntegerParser().parse( lines );
		addValues( value );
		
		matrix = new int[values.get(0)][values.get(0)];
		
		int k = 1; 
		while(k < values.size()) {
			for (int i =0; i < matrix.length; i++){
				for (int j = 0; j < matrix[0].length; j++){
					matrix[i][j] = values.get(k);
					k++;
			    }
			}
		}
	}
	
	private boolean checkCoordinates(int i, int j) {
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return false;
		}
		
		return true;
	}
	
	private void addValues(List<Integer> value) {
		for(Integer e : value) {
			values.add(e);
		}
	}
		
	/**
	 * Returns the matrix size (n)
	 * @return int with the size
	 */
	public int getSize() {
		return matrix.length;
	}
	
	/**
	 * Returns the value of the matrix given some coordinates
	 * @return int with the value
	 */
	public int getValue(int row, int column)
    {
		checkCoordinates(row, column);
        return matrix[row][column];
    }
	
	/**
	 * Returns the matrix
	 * @return int[][] containing the matrix
	 */
	public int[][] getMatrix(){
		return this.matrix;
	}
	 
	/**
	 * Prints in the console all the matrix elements.
	 */
	public void write() {
		for (int i =0; i < matrix.length; i++){
	    	for (int j = 0; j < matrix[0].length; j++){
	    		System.out.print(matrix[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	}
	
	/**
	 *  sumDiagonal1(). Computes the summation of all the elements of the matrix diagonal. 
	 *  This implementation must iterate over all the matrix elements, but only sums appropriate elements. 
	 *  So, the complexity is quadratic.
	 */
	public int sumDiagonal1() {
		int sum = 0;
		
		int i = 0;
		int j = matrix[0].length -1;
		
		while(i < matrix.length && j >= 0) {
			sum += matrix[i][j];
	    	i++;
	    	j--;
	    }
		
		return sum;
	}
	

	/**
	 * sumDiagonal2(). Computes the summation of all the elements of the matrix 
	 * diagonal. This second version should only consider the elements of the 
	 * main diagonal. So, the complexity is linear.
	 */
	public int sumDiagonal2() {
		int sum = 0;
		
		for (int i =0; i < matrix.length; i++){
	    	for (int j = 0; j < matrix[0].length; j++){
	    		sum += matrix[i][j];
	    	}
	    }
		
		return sum;
	}
	
	/**
	 * travelPath(int i, int j). Given a matrix with integer numbers between 1 and 4, this method 
	 * iterates through the matrix starting at position (i, j) according to the following number 
	 * meanings: 1 – move up; 2 – move right; 3 – move down; 4 – move left. Traversed elements 
	 * would be set to -1 value. The process will finish if it goes beyond the limits of the matrix
	 *  or an already traversed position is reached. To make sure your code works, create a text 
	 *  file with the previous example indicated in MatrixOperations(String fileName) and test it. 
	 *  For that file, the final output for a call travelPath(3, 0) 
	 */
	public void travelPath(int i, int j) {
		checkCoordinates(i, j);
		int movements = 0;
		
		while(checkCoordinates(i, j) && matrix[i][j] != -1) {			
			if(matrix[i][j] == 1) {
				movements++;
				matrix[i][j] = -1;
				matrix[i][j] = matrix[i--][j];
			}
			else if(matrix[i][j] == 2) {
				movements++;
				matrix[i][j] = -1;	
				matrix[i][j] = matrix[i][j++];
			}
			else if(matrix[i][j] == 3) {
				movements++;
				matrix[i][j] = -1;
				matrix[i][j] = matrix[i++][j];
			}
			else if(matrix[i][j] == 4) {
				movements++;
				matrix[i][j] = -1;
				matrix[i][j] = matrix[i][j--];
			}
		}
		
		System.out.println("Number of movements: " + movements);
		write();

	}
}
