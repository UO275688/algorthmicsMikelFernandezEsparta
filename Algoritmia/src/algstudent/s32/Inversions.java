package algstudent.s32;

import java.util.ArrayList;
import java.util.List;

//O(nlogn)
public class Inversions {

	private static List<Integer> list = new ArrayList<Integer>();
	private List<Integer> sorted = new ArrayList<Integer>();

	public Inversions(List<Integer> ranking) {
		setList(ranking);
	}
	
	public void setList(List<Integer> list) {
		Inversions.list = list;
	}

	public String start() {
		return numInversions(list) + "";
	}

	private int numInversions(List<Integer> ranking) {
		int counter = 0;
		
		if(ranking.size() < 2) {
			return counter;
		}
		else {
			int center = ranking.size() / 2;
					
			List<Integer> leftList = ranking.subList(0, center);
			List<Integer> rightList = ranking.subList(center, ranking.size());
			
			counter += numInversions(leftList);
			counter += numInversions(rightList);
			counter += combineLists(leftList, rightList);
		}
		
		return counter;
	}

	private int combineLists(List<Integer> leftList, List<Integer> rightList) {
		int counter = 0;
		int indexLeft = 0;
		int indexRight = 0;
		int size = leftList.size() + rightList.size();
		
		for(int i = 0; i < size; i++) {
			if(indexLeft >= leftList.size()) {
				sorted.add(rightList.get(indexRight));
				indexRight++;
			}
			
			else if(indexRight >= rightList.size()) {
				sorted.add(leftList.get(indexLeft));
				indexLeft++;
			}
			
			else if(leftList.get(indexLeft) <= rightList.get(indexRight)) {
				sorted.add(leftList.get(indexLeft));
				indexLeft++;
			}
			else {
				sorted.add(rightList.get(indexRight));
				indexRight++;
				counter++;
			}
		}
		
		return counter;
	}
}