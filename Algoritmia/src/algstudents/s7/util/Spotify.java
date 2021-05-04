package algstudents.s7.util;

import java.io.BufferedReader;
import java.io.FileReader;
import algstudent.s6.Song;

public class Spotify extends BranchAndBound{
	
	private static final int MAX_DURADTION = 0;

	private static int MAX_DURATION = 5;
	
	private int totalDuration = 0;
	private static int totalScore = 0;
	
	private int[] result;
	private Song[] songs;

	public Spotify(String file) 
	{	
		System.out.println("File name: " + file);
		readFile(file);	
		showListOfSongs();				
		EstadoSpotify es = new EstadoSpotify(songs, MAX_DURADTION); 
		es.calculateHeuristicValue();
	}
	
	public void readFile(String ruta){
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(ruta));
			int i = -1;
			while(bf.ready()){
				if(i == -1){
					int n = Integer.parseInt(bf.readLine());
					songs = new Song[n];
					result = new int[n];
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
	
	private void showListOfSongs(){		
		System.out.println("Number of songs: " + songs.length);	
		System.out.println();	
		System.out.println("List of songs: ");
		
		for(int i = 0; i < songs.length; i++) {
			System.out.println(songs[i].toString());	
		}
		
		for(int i = 0; i < songs.length; i++){
			totalDuration += songs[i].getDuration();
			totalScore += songs[i].getScore();
		}
		
		System.out.println();	
		System.out.println("Length of the blocks: " + totalDuration + " seconds");
		System.out.println("Total score: " + totalScore);
		
		System.out.println();
		System.out.println("Best block A: ");
		
		for(int i = 0; i < songs.length; i++){			
			if(result[i] == 1){				
				System.out.println(songs[i].toString());				
			}			
		}
		
		System.out.println("Max duration is " + MAX_DURATION);
	}

	public static int getTotalScore() {
		return totalScore;
	}
}
