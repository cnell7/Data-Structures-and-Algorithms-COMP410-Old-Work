package DiGraph_A5;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class DiGraph implements DiGraphInterface {
	
	HashMap<Long, String> nodeString;
	HashMap<String, Node> nodeList;
	HashMap<Long, String> edgeString;
	HashMap<String, Edge> edgeList;
	Node startNode;
	long nodeCount;
	long edgeCount;
	
	public DiGraph() { 
		
		nodeString = new HashMap<Long, String>();
		nodeList = new HashMap<String, Node>();
		edgeString = new HashMap<Long, String>();
		edgeList = new HashMap<String, Edge>();
		nodeCount = 0;
		edgeCount = 0;
	}

	public boolean addNode(long idNum, String label) {
		
		if(nodeString.containsKey(idNum) || nodeList.containsKey(label)) {
			return false;
		}
		
			
		nodeString.put(idNum, label);
		nodeList.put(label, new Node(label, idNum));
		return true;
	}

	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		 eLabel = sLabel + "-" + dLabel;
		
		if(edgeString.containsKey(idNum) || nodeList.get(sLabel) == null ||
				nodeList.get(dLabel) == null || edgeList.get(sLabel + "-" + dLabel) != null) {
			
			return false;
		}
		
		edgeString.put(idNum, eLabel);
		edgeList.put(eLabel, new Edge(idNum, sLabel, dLabel, weight, eLabel));		
		nodeList.get(sLabel).addAdj(nodeList.get(dLabel));
		nodeList.get(sLabel).addEdge(eLabel, edgeList.get(eLabel));
		return true;
	}

	public boolean delNode(String label) {
		
		if(nodeList.get(label) != null) {
				nodeString.remove(nodeList.get(label).getId());
				nodeList.remove(label);
				return true;
		}
		return false;
	}

	public boolean delEdge(String sLabel, String dLabel) {
				
		if(nodeList.get(sLabel) != null || nodeList.get(dLabel) != null) {
			if(edgeList.get(sLabel + "-" + dLabel) != null) {
				
				edgeString.remove(nodeList.get(sLabel).getEdge(sLabel + "-" + dLabel).getId());
				edgeList.remove(sLabel + "-" + dLabel);
				return true;
			}
		}
		return false;
	}

	public long numNodes() {
		nodeCount = 0;
		for (String key : nodeList.keySet()) {

			nodeCount++;
		}
		return nodeCount;
	}

	
	public long numEdges() {
		edgeCount = 0;
		for (String key : edgeList.keySet()) {

			edgeCount++;
		}
		return edgeCount;
	}

	public void printNodes() {
		
		for (long name: nodeString.keySet()){
			
            long key = name;
            String value = nodeString.get(key);  
            System.out.println(key + " " + value);  
		} 
	}
	public ShortestPathInfo[] shortestPath(String label) {
		ArrayList<Node> ajNodes;
		ShortestPathInfo[] path = new ShortestPathInfo[nodeString.size()];
		Node n;
		Node clone;
		int ajSize;
		int counter = 1;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new nodeComparator());
		
		pq.add(nodeList.get(label));

		path[0] = new ShortestPathInfo(label, 0);
		
		while(pq.size() != 0) {
			n = pq.remove();
			ajNodes = n.getAjNodes();
			ajSize = ajNodes.size();
			
			for(int i = 0; i < ajSize; i++) {
				
				if(ajNodes.get(i).getIsTrue() == false) {	
					
					if(n.getEdgeWeight(ajNodes.get(i)) + n.getLengthTo() < ajNodes.get(i).getLengthTo()||
							ajNodes.get(i).getLengthTo() == 0) {		
						
						ajNodes.get(i).setLengthTo(n.getEdgeWeight(ajNodes.get(i)) + n.getLengthTo());
					}
					pq.add(ajNodes.get(i));
				}
			}
			n.setTrue();
		}
		
		for(String name: nodeList.keySet()) {
			if(name != label) {
				
				if(nodeList.get(name).getLengthTo() == 0) {
					path[counter] = new ShortestPathInfo(nodeList.get(name).getLabel(), -1);
				}else {
					path[counter] = new ShortestPathInfo(nodeList.get(name).getLabel(), nodeList.get(name).getLengthTo());
				}
				counter++;
			}
		}
		
		return path;
	}
}