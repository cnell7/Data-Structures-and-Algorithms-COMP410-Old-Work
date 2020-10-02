package DiGraph_A5;

import java.util.Comparator;

public class nodeComparator implements Comparator<Node> {

	
	public int compare(Node o1, Node o2) {
		if (o1.getLengthTo() > o2.getLengthTo()) {
			return 1;
		} else if (o1.getLengthTo() < o2.getLengthTo()) {
			return -1;
		} else {
			return 0;
		}
	}
}
