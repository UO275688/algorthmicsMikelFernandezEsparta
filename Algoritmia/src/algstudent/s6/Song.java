package algstudent.s6;

public class Song {

	public String id;
	public int duration;
	public int score;
	
	public Song(String id, String duration, int score){
		this.id = id;
		int min = Integer.parseInt(duration.split(":")[0]) * 60;
		int seconds = Integer.parseInt(duration.split(":")[1]);
		this.duration = min + seconds;				
		this.score = score;
	}
	
	public String getId() {
		return id;
	}

	public int getDuration() {
		return duration;
	}

	public int getScore() {
		return score;
	}

	public String toString(){
		return "id: " + id + " seconds: " + duration + " score: " + score;
	}
}