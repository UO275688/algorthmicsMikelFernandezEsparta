package algstudent.s0;

import java.io.IOException;

public class Main {

	private static final String MATRIX_FILE = "files/matrix.txt";
	
	public static void main(String[] args){
		new Main().run();
	}
	
	private void run() {
		try {
			execute();
		} catch (RuntimeException re) {
			handleRuntimeException(re);
		}
		catch(IOException ioe) {
			handleIOException(ioe);
		}
		catch (Exception e) {
			handleException(e);
			return;
		}
	}

	private void handleIOException(IOException ioe) {
		System.out.println(ioe.getMessage());
		
	}

	private void handleException(Exception e) {
		System.out.println(e.getMessage());
		
	}

	private void handleRuntimeException(RuntimeException re) {
		re.printStackTrace();	
	}


	private void execute() throws IOException {
		MatrixOperations ex = new MatrixOperations(MATRIX_FILE);				
		ex.travelPath(3, 0);
		
	}
}
