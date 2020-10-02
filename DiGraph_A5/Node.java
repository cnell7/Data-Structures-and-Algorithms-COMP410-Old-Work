package DiGraph_A5;
import java.util.HashMap;
import java.util.ArrayList;

public class Node{

	String s;
	long id;
	long lengthTo;
	boolean isTrue;
	Node previousNode;
	HashMap<String, Node> aj;
	HashMap<String, Edge> ed;
	ArrayList<Node> ajNodes;
	
	public Node(String s, long id) {
		this.s = s;
		this.id = id;
		this.isTrue = false;
		aj = new HashMap<String, Node>();
		ed = new HashMap<String, Edge>();
		ajNodes = new ArrayList<Node>();
	}
	
	public String getLabel() {
		return s;
	}
	public long getId() {
		return id;
	}
	public Edge getEdge(String s) {
		return ed.get(s);
	}
	public long getLengthTo() {
		return lengthTo;
	}
	public boolean getIsTrue() {
		return isTrue;
	}
	public long getEdgeWeight(Node n) {
		return ed.get(this.getLabel() + "-" + n.getLabel()).getWeight();
	}
	public ArrayList<Node> getAjNodes() {
		return ajNodes;
	}
	public void setTrue() {
		isTrue = true;
	}
	public void setPreviousNode(Node n) {
		previousNode = n;
	}
	public void setLengthTo(long l) {
		lengthTo = l;
	}
	public void addAdj(Node n) {
		aj.put(n.getLabel(), n);
		ajNodes.add(n);
	}
	public Node getAj(String s) {
		return aj.get(s);
	}
	public void printAdj() {
		for (String name: aj.keySet()){
			 
            System.out.println(name);  
		} 
	}
	public void addEdge(String s, Edge e) {
		ed.put(s,e);
	}

}
