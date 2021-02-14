package algstudent.s0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	//private static PrintStream out = null;

	/**
	 * Sends the full stack trace of the exception received to the log
	 * prefixing it with a timestamp 
	 * @param t, the exception to be logged
	 */
	public static void log(String message) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("fichero.log", true));
			out.println(message);
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
