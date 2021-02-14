package algstudent.s0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {

	public List<String> loadLines(String inFileName) {
		List<String> res = new LinkedList<>();
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(inFileName));
			while(entrada.ready()) {
				String linea = entrada.readLine();
				res.add(linea);
			}
			entrada.close();
		}
		catch(IOException e) {
			Logger.log("Unrecoverable error: " + inFileName + " does not exist");
		}
		
		return res;
	}
}
