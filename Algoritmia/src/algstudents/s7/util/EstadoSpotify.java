package algstudents.s7.util;

import java.util.ArrayList;
import java.util.Arrays;
import algstudent.s6.Song;

public class EstadoSpotify extends Node{

	public Song[] songs;
	public int maxDuration;
	public static int nodosGenerados;
	
	public int[] result;
	public int[] blocks = new int[2];
	public int score = 0;
	public int level;
	int valueHeuristic;
	
	public EstadoSpotify(EstadoSpotify padre, int i){
		super();
		
		blocks = Arrays.copyOf(padre.blocks, blocks.length);
		result = Arrays.copyOf(padre.result, songs.length);
		score = padre.score;
		level = padre.level;
				
		if(i < blocks.length) { 
			blocks[i] += songs[level].getDuration();
			result[level] = i+1;
			score += songs[level].getDuration();				
		}
				
		calculateHeuristicValue();
	}
	
	public EstadoSpotify(Song[] songs, int max){
		super();
		nodosGenerados = 0;
		this.maxDuration = (max*60);
		this.songs = songs;
		this.result = new int[songs.length];
		Arrays.sort(this.songs);
			}
	
	@Override
	public void calculateHeuristicValue() {
		int value = this.score;
			
		for(int i = level; i < songs.length; i++){
			if(blocks[0] + songs[i].getDuration() <= maxDuration){
				blocks[i] += songs[i].getDuration();
				value += songs[i].getScore();
			}
			if(level == songs.length){
				valueHeuristic -= value;
			}
			else{
				value -= songs[i].getScore();
			}
		}
		valueHeuristic = Spotify.getTotalScore() - value;			
	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> children = new ArrayList<Node>();
		
		for(int i = 0; i <= blocks.length; i++){
			if(i == blocks.length){
				nodosGenerados++;
				Node child = new EstadoSpotify(this,i); 
				children.add(child);
			}
		}
		return children;
	}

	@Override
	public boolean isSolution() {
		boolean result = false;
		if(level == songs.length){
			result = true;
		}
		return result;
	}
	
	public String toString(){
		String toString = "";
		
		for(int i = 0; i < blocks.length; i++){
			if(i!=0){
				toString += "\n";
			}
			toString += "Bloque "+(i+1)+": " + blocks[i] + "s\n";
			int puntuacion = 0;
			for(int j = 0; j < result.length; j++){
				if(result[j] == 1){
					toString += "\t"+songs[j]+"\n";
					puntuacion += songs[j].getScore();
				}
			}
			toString += "\tPuntuacion: "+ puntuacion;
		}
		
		toString += "\nPuntuacion total: " + this.score + " level: " + level;
		
		return toString;
	}
}
