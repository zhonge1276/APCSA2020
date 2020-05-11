package FrqSet3;

public class Practice3_2 {
public interface NumberGroup{
	boolean contains(int num);
}

public class Range implements NumberGroup{
	private int min;
	private int max;
	
	public Range(int min, int max) {
		this.min=min;
		this.max=max;
	}
	public boolean contains(int num) {
		return num >= min && num <= max;
	}
}

public boolean contains(int num) {
	for (NumberGroup group : groupList) {
		if (group.contains(num)) {
			return true;
		}
	}
	return false;
}
}
