package algstudent.s32;

import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InversionsTimes {
	private static List<Integer> ranking;
	
	public static void main(String args[]) { 
		int numberFiles = 7;
		
		for (int i = 1; i <= numberFiles; i++) {
			String fileName = Paths.get("").toAbsolutePath().toString() + "/src/algstudent/s32/ranking" + i + ".txt";
			System.out.println("FILE: " + fileName);
			
			ranking = readRankingFromFile(fileName);
	        Inversions inv1 = new Inversions(ranking);	
	        long  t1 = System.currentTimeMillis();              
	        System.out.println("Number of inversions = " + inv1.start());                 				
	        long  t2 = System.currentTimeMillis();              
	        if(i>1) System.out.println("The time for the algorithm O(n logn) is: " + (t2-t1) + " milliseconds");
	        
	        
	        ranking = readRankingFromFile(fileName);
	        InversionsQuadratic inv2 = new InversionsQuadratic(ranking);	
	        long t3 = System.currentTimeMillis();              
	        System.out.println("Number of inversions = " + inv2.start());                 				
	        long t4 = System.currentTimeMillis();              
	        if(i>1)  System.out.println("The time for the algorithm O(n^2) is: " + (t4-t3) + " milliseconds");
	        
	        System.out.println("\n****************************\n");
		}	
	}
	
	public static List<Integer> readRankingFromFile(String file)
	{
		BufferedReader fich = null;
		String line;
		List<Integer> elements = new ArrayList<Integer>();

		try {
			fich = new BufferedReader(new FileReader(file));
			line = fich.readLine(); //first element of the file
			while (line != null) {
				elements.add(Integer.parseInt(line));
				line = fich.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("There is no file: "+file);
		} catch (IOException e) {
			System.out.println("Error reading the file: "+file);
		} finally {
			if (fich!=null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error closing the file: "+file);
					e.printStackTrace();
				}
		}

		return elements;
	}
	
}
