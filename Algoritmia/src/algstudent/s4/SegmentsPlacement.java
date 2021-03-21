package algstudent.s4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SegmentsPlacement {

	private static List<Integer> list = new ArrayList<Integer>();
	
	public SegmentsPlacement(List<Integer> ranking) {
		setList(ranking);
	}
	
	public SegmentsPlacement() {
		
	}

	public void setList(List<Integer> list) {
		SegmentsPlacement.list = list;
	}

	public static List<Double> greedy1(List<Integer> list) {
		List<Double> midPoints = new ArrayList<Double>();
		int i = 0;
		int first = 0;
		int second = list.get(0);		
		while(i < list.size()) {
			double value = average(first, second);
			midPoints.add(value);			
			first = second;
			i++;
			if(i < list.size())
				second += list.get(i);
			else
				break;
		}
		return midPoints;
	}
	
	private static void showMidPoints(List<Double> midPoints, List<Integer> list) {
		int i = 0;
		int first = 0;
		int second = list.get(0);
		for(int k = 0; k < midPoints.size(); k++) {
			System.out.println("S" + k + ": (" + first + " to " + second + 
					"),midpoint = " + midPoints.get(k));
			first = second;
			i++;
			if(i < list.size())
				second += list.get(i);
			else
				break;
		}
	}
	
	private static double countPufosos(List<Double> midPoints) {
		double pufosos = 0;
		for(Double a : midPoints){
			pufosos += a;
		}
		return pufosos;
	}

	private static double average(int x, int y) {
		double average = (x + y) / 2;
		return average;
	}

	public static List<Double> greedy2(List<Integer> list) {
		Collections.sort(list);
		Collections.reverse(list);
		List<Double> midPoints = new ArrayList<Double>();
		int i = 0;
		int first = 0;
		int second = list.get(0);	
		while(i < list.size()) {
			double value = average(first, second);
			midPoints.add(value);			
			first = second;
			i++;
			if(i < list.size())
				second += list.get(i);
			else
				break;
		}

		return midPoints;
	}

	public static List<Double> greedy3(List<Integer> list) {
		Collections.sort(list);
		
		List<Double> midPoints = new ArrayList<Double>();
		
		int i = 0;
		int first = 0;
		int second = list.get(0);
				
		while(i < list.size() && second != 0) {
			double value = average(first, second);
			midPoints.add(value);			
			first = second;
			i++;
			if(i < list.size())
				second += list.get(i);
			else
				break;
		}
		
		return midPoints;
	}
	
	
	
	public static void main(String args[]) { 
		int numberFiles = 2;
		
		for (int i = 1; i <= numberFiles; i++) {
			String fileName = Paths.get("").toAbsolutePath().toString() + "/src/algstudent/s4/game" + i + ".txt";
			System.out.println("FILE: " + fileName);
			
			list = readRankingFromFile(fileName);
	            
			list.remove(0); //remove the value of size
			
			List<Double> midPoints1 = greedy1(list);                 				
	        showMidPoints(midPoints1, list);
			System.out.println("Cost of greedy 1 = " + countPufosos(midPoints1) + " pufosos");
			
	        System.out.println("\n---------------------------\n");

			List<Double> midPoints2 = greedy2(list);    
			Collections.sort(list);
			Collections.reverse(list);
	        showMidPoints(midPoints2, list);
			System.out.println("Cost of greedy 2 = " + countPufosos(midPoints2) + " pufosos");
			
			System.out.println("\n---------------------------\n");

			List<Double> midPoints3 = greedy3(list);                 				
			Collections.reverse(list);
	        showMidPoints(midPoints3, list);
			System.out.println("Cost of greedy 3 = " + countPufosos(midPoints3) + " pufosos");
			
	        System.out.println("\n****************************\n");
		}	
  	}
	
	public static List<Integer> readRankingFromFile(String file) {
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
