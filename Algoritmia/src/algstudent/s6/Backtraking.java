package algstudent.s6;

import java.io.BufferedReader;
import java.io.FileReader;

public class Backtraking {
	
	private int n;
	
	private Song[] songs;
	
	private int[] bestResult;
	private int[] bestBlock = new int[2];	
	private int[] result;
	private int[] blocks = new int[2];
	
	private int value = 0;
	private int bestValue = 0;
	
	public void showLists(String file, int max){
		readFile(file);
		showListOfSongs();		
		backtracking(0);				
		showBlocks();
	}
	
	public void backtracking (int current)
	{
		if (current == n) {			
			if(value > bestValue){				
				bestValue = value;
				bestResult = result.clone();
				bestBlock[0] = blocks[0];
				bestBlock[1] = blocks[1];				
			}			
		}
		else{
			for(int i = 0; i <= blocks.length; i++){				
				if(i < blocks.length){						
					result[current] = i+1;
					blocks[i] += songs[current].getDuration();
					value += songs[current].getScore();
						
					backtracking (current + 1);

					value -= songs[current].getScore();
					blocks[i] -= songs[current].getDuration();
					result[current] = 0;
				}
				else{
					backtracking (current + 1);
				}				
			}
		}
	}
	
	private void showListOfSongs(){		
		System.out.println("Number of songs: " + n);	
		System.out.println();	
		System.out.println("List of songs: ");
		
		for(int i = 0; i < songs.length; i++) {
			System.out.println(songs[i].toString());	
		}
		
		int totalDuration = 0;
		int totalScore = 0;
		
		for(int i = 0; i < n; i++){
			totalDuration += songs[i].getDuration();
			totalScore += songs[i].getScore();
		}
		
		System.out.println();	
		System.out.println("Length of the blocks: " + totalDuration + " seconds");
		System.out.println("Total score: " + totalScore);
	}
	
	private void showBlocks(){
		System.out.println();
		System.out.println("Best block A: ");
		
		for(int i = 0; i < n; i++){			
			if(bestResult[i] == 1){				
				System.out.println(songs[i].toString());				
			}			
		}
		
		System.out.println();

		System.out.println("Best block B: ");
		
		for(int i = 0; i < n; i++){			
			if(bestResult[i] == 2){				
				System.out.println(songs[i].toString());				
			}			
		}
	}
	
	public void readFile(String file){
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(file));
			int i = -1;
			while(bf.ready()){
				if(i == -1){
					n = Integer.parseInt(bf.readLine());
					songs = new Song[n];
					result = new int[n];
					bestResult = new int[n];
					i++;
				}
				else{
					String[] line = bf.readLine().split("\t");
					songs[i] = new Song(line[0], line[1], Integer.parseInt(line[2]));
					i++;
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
