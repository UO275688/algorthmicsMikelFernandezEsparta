package algstudent.s12;

import java.util.Random;

public class Loop4 {
	public static void loop4(int n) {
		/*n^4 algorithm O(n^4) */
		Random rn = new Random();
		@SuppressWarnings("unused")
		int cont=0;
		for (int i=1; i<=n; i++)
			for (int j=1; j<=n; j++)
				for (int k=1; k<=n; k++)
					for (int l=1; l<=n; l++)
						cont += rn.nextInt();
	}
	
	public static void main(String arg []){
		long t1,t2;
		int nTimes= Integer.parseInt(arg [0]);
	
		for (int n=1; n<=100000; n*=2) {
			t1 = System.currentTimeMillis();
	 
			for (int repetitions=1; repetitions<=nTimes; repetitions++) {
				loop4(n);
			} 
	 
			t2 = System.currentTimeMillis();
			long t = (t2 - t1);
			float time = (float)t/nTimes;
			System.out.println("n="+n+ "**TIME=" + time + " ** nTimes=" + nTimes);
	 }  // for
	
	} // main
} //class