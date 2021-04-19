package algstudent.s6;

import java.nio.file.Paths;

public class BestList {

	public static void main(String[] args) {		
		Backtraking bactracking = new Backtraking();	
		String fileName = Paths.get("").toAbsolutePath().toString() + "/src/algstudent/s6/List01.txt";
		bactracking.showLists(fileName, 20);
	}
}