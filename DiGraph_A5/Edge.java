package DiGraph_A5;

public class Edge {
	
	String s;
	String d;
	long weight;
	String l;
	long id;

	public Edge(long id, String s, String d, long w, String l) {
		
		this.id = id;
		this.s = s;
		this.d = d;
		this.weight = w;
		this.l = l;
	}
	
	public String getSLabel() {
		return s;
	}
	public String getDLabel() {
		return d;
	}
	public long getId() {
		return id;
	}
	public long getWeight() {
		return weight;
	}
	
}
