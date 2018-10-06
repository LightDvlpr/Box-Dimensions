package project4;
import java.util.Comparator;
public class BoxComparator implements Comparator<Box> {
	@Override
	public int compare(Box b1, Box b2) {
		if(b1.Volume() < b2.Volume())
			return -1;
		else
			return 1;
	}
	
}
