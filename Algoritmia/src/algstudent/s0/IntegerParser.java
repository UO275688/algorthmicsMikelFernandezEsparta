package algstudent.s0;

import java.util.ArrayList;
import java.util.List;

public class IntegerParser {
	
	private int dimension;

	public List<Integer> parse(List<String> lines) {
		List<Integer> lista = new ArrayList<Integer>();
		
		dimension = Integer.valueOf(lines.get(0));
		lista.add(dimension);
		lines.remove(0);
		
		for (String linea : lines) {
			try {
				if (linea.equals("")) {
					throw new ErrorFichero("It is empty");
				}			
				
				String trozos[] = linea.split("\t");

				if (trozos.length != dimension) {
					throw new ErrorFichero("Incorrect length");
				}
				
				for(int i = 0; i < dimension;i++) {
					Integer n = Integer.valueOf(trozos[i]);
					lista.add(n);
				}	
				
			} catch (ErrorFichero e) {
				Logger.log(e.getMessage());
			}
		}
		return lista;
	}
}
