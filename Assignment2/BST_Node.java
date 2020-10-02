package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }


  public String getData(){ 
	  return data; 
  }
  public BST_Node getLeft(){ 
	  return left; 
  }
  public BST_Node getRight(){ 
	  return right; 
  }

  //
  public boolean containsNode(String s){ 
	  return false; 
  }
  public boolean insertNode(String s){ 
	  
	  if(s.compareTo(getData()) > 0) {
		  
		  right = new BST_Node(s);
		  return true;
	  } else {
		  
		  left = new BST_Node(s);
		  return true;
	  }
  }
  public boolean removeNode(BST_Node curr, String s, int numKids){ 
	  
	  BST_Node min;
	  
	  if(curr.getData() == s) {
		  
		  min = findMin(curr.getRight());
		  
	  }
	  
	  if(numKids == 0) {
		  
		  if(s.compareTo(curr.getData()) > 0){
			  
			  curr.right = null;
			  return true;
		  } else {
			  
			  curr.left = null;
			  return true;
		  }
		  
	  } else if(numKids == 1) {
		  
		  //s is to right
		  if(s.compareTo(curr.getData()) > 0) {
			  
			  //child is to right
			  if(curr.getRight().getRight() == null) {
				  
				  curr.right = curr.getRight().getLeft();
				  return true;
			  } else { //child is to left
				  
				  curr.right = curr.getRight().getRight();
				  return true;
			  }
		  } else { //s is to left
			  
			  if(curr.getLeft().getRight() == null) {
				  
				  curr.left = curr.getLeft().getLeft();
				  return true;
				  
			  } else {
				  
				  curr.left = curr.getLeft().getRight();
				  return true;
			  }
		  }
		  
	  } else {
		  
		  if(s.compareTo(curr.getData()) > 0) {
			   
			  min = findMin(curr.getRight());
			  
			  if(min.getLeft() != null) {
				  min.getLeft().left = curr.getRight().getLeft();
				  min.getLeft().right = curr.getRight().getRight();
				  curr.right = min.getLeft();
				  min.left = null;
			  } else {
				  min.left = curr.getRight().getLeft();
				  min.right = null;
				  curr.right = min;
				  min = null;
			  }
			  return true;
		  } else {
			  
			  min = findMin(curr.getLeft());
			  
			  if(min.getLeft() != null) {
				  min.getLeft().left = curr.getLeft().getLeft();
				  min.getLeft().right = curr.getLeft().getRight();
				  curr.left = min.getLeft();
				  min.left = null;
			  } else {
				  min.left = curr.getLeft().getLeft();
				  min.right = curr.getLeft().getRight().getRight();
				  curr.left = min;
				  min = null;
			  }
			  
			  
			  return true;
		  }
	  }
	  
  }
  public BST_Node findMin(BST_Node curr){ 
	  
	  if(curr.getRight() != null) {
		  
		  curr = curr.getRight();
	  } else {
		  
		  return curr;
	  }
	  while(curr != null) {
		  
		  if(curr.getLeft() == null) {
			  
			  return curr;
		  }
		  if(curr.getLeft().getLeft() != null) {
			  
			  curr = curr.getLeft();
		  } 
		  else {
			  
			  break;
		  }
	  }
	  return curr;
	  
  }
  public BST_Node findMax(){ 
	  return right; 
  }
  public int getHeight(BST_Node node){ 
	  
	  if (node == null) 
          return -1; 
      else 
      { 
          int lDepth = getHeight(node.left); 
          int rDepth = getHeight(node.right); 
 
          if (lDepth > rDepth) 
              return (lDepth + 1); 
           else 
              return (rDepth + 1); 
      } 
  }

  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}