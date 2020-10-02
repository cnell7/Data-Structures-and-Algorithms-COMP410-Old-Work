package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(0, "a");
      d.addNode(1, "b");
      d.addNode(2, "c");
      d.addNode(3, "d");

           
      d.addEdge(0, "a", "b", 3, "a-b");
      d.addEdge(1, "a", "c", 5, "a-c");
      d.addEdge(2, "b", "c", 4, "b-c");
      d.addEdge(3, "c", "d", 10, "c-d");
      d.addEdge(4, "a", "d", 1, "a-d");

      
      d.shortestPath("a");
      
    }
}