package algstudent.s32;

import java.util.ArrayList;
import java.util.List;

public class InversionsQuadratic {

	private static List<Integer> list = new ArrayList<Integer>();
	
	public InversionsQuadratic(List<Integer> ranking) {
		setList(ranking);
	}

	public String start() {
		int count = 0;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j)<list.get(i)) {
					count += 1;
				}
			}
		}
		return count + "";
	}

	public void setList(List<Integer> list) {
		InversionsQuadratic.list = list;
	}
}
