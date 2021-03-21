package algstudent.s4;

import java.util.ArrayList;
import java.util.Random;


public class SegmentsPlacementTimes {
		
	private static ArrayList<Integer> createList(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		
		for(int i = 0; i < n ; i++) {
			list.add(r.nextInt(100));
		}
		
		return list;
	}
	
	public static void main(String args[]) { 
		int num = 204800 * 2;		
		for (int i = 100; i <= num; i *= 2) {
			System.out.println("N: " + i);			
			ArrayList<Integer> list = createList(i);			
			long  t1 = System.currentTimeMillis();              
	        SegmentsPlacement.greedy1(list);                 				
	        long  t2 = System.currentTimeMillis();              
	        System.out.println("The time for the algorithm greedy1 is: " + (t2-t1) + " milliseconds");	        
	        
	        long  t3 = System.currentTimeMillis();              
	        SegmentsPlacement.greedy2(list);                 				
	        long  t4 = System.currentTimeMillis();              
	        System.out.println("The time for the algorithm greedy2 is: " + (t4-t3) + " milliseconds");	        
	        
	        long  t5 = System.currentTimeMillis();              
	        SegmentsPlacement.greedy3(list);                 				
	        long  t6 = System.currentTimeMillis();              
	        System.out.println("The time for the algorithm greedy3 is: " + (t6-t5) + " milliseconds");			
	        
	        System.out.println("\n****************************\n");
		}	
  	}
}
