package algstudent.s2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the SELECTION */
public class Selection extends Vector {
	public Selection(int nElements) {
		super(nElements);
	}
	
	@Override
	public void sort() {
		int posMin;
		
		for(int i = 0; i < elements.length - 1; i++) {
			posMin = Vector.findPosMin(elements, i); //O(n)
			Vector.interchange(elements, i, posMin);
		}
	}  
	
	
	@Override
	public String getName() {
		return "Selection";
	} 
} 
