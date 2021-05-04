package algstudents.s7.util;

import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) 
	{		
		for(int i = 1; i <= 3; i++) {
			String fileName = Paths.get("").toAbsolutePath().toString() + "/src/algstudent/s7/Lista0" + i + ".txt";

			Spotify problemaSpotify = new Spotify(fileName); 
			
			long t1 = System.currentTimeMillis();

			problemaSpotify.branchAndBound(problemaSpotify.getRootNode()); 
			
			long t2 = System.currentTimeMillis();

			long time = t2 - t1;
			
			problemaSpotify.printSolutionTrace(); 
			
			System.out.println("Datos del arbol generado:");
			System.out.println("\t- " + time + " milisegundos");
			//System.out.println("\t- " + ((EstadoSpotify)problemaSpotify.getRootNode()).nodosGenerados + " nodos generados");
			//System.out.println("\t- " + problemaSpotify.nodosVisitados + " nodos visitados");
			//System.out.println("\t- " + (((EstadoSpotify)problemaSpotify.getRootNode()).nodosGenerados - problemaSpotify.nodosVisitados) + " nodos podados");
		}		
	}
}
