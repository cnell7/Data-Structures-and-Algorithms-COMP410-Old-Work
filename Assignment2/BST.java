package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		
		if(root == null) {
			
			root = new BST_Node(s);
			this.size++;
			return true;
			
		} 
		
		BST_Node curr = root;
		
		while(curr != null) {
			
			if(s.compareTo(curr.getData()) == 0) {
				
				return false;
				
			} else if(s.compareTo(curr.getData()) > 0) {
				
				if(curr.getRight() == null) {
					
					this.size++;
					return curr.insertNode(s);
				} else {
					
					curr = curr.getRight();
				}
			} else {
				
				if(curr.getLeft() == null) {
					
					this.size++;
					return curr.insertNode(s);
				} else {
					
					curr = curr.getLeft();
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean remove(String s) {
		
		int numKids = 0;
		BST_Node min = null;
		BST_Node curr = getRoot();
		
		if(size == 0) {
			return false;
		}
		
		if(curr.getData() == s) {
			
			if(size == 1) {
				
				root = null; 
				return true;
			}
			
			min = curr.findMin(curr);
			
			if(min.getLeft() != null) {
				
				min.getLeft().left = curr.getLeft();
				min.getLeft().right = curr.getRight();
				root = min.getLeft();
				min.left = null;
				
			} else {
				root = min;
			}
			size--;
			return true;
			
		}
		
		while(curr != null) {
			
			if(s.compareTo(curr.getData()) > 0) {
				
				if(s.compareTo(curr.getRight().getData()) == 0) {
					
					if(curr.getRight().getRight() == null && curr.getRight().getLeft() == null) {
						numKids = 0;
					}
					else if(curr.getRight().getRight() == null || curr.getRight().getLeft() == null) {
						numKids = 1;	
					} else {
						numKids = 2;
					}
					size--;
					return curr.removeNode(curr, s, numKids);
					
				} else {
					
					curr = curr.getRight();
				}
			} else {
				
				if(s.compareTo(curr.getLeft().getData()) == 0) {
					
					if(curr.getLeft().getRight() == null && curr.getLeft().getLeft() == null) {
						numKids = 0;
					}
					else if(curr.getLeft().getRight() == null || curr.getLeft().getLeft() == null) {
						numKids = 1;	
					} else {
						numKids = 2;
					}
					size--;
					return curr.removeNode(curr, s, numKids);
				} else {
					
					curr = curr.getLeft();
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String findMin() {
		
		BST_Node curr = getRoot();
		if(size == 0) {
			return null;
		}
		
		while(curr != null) {
			
			if(curr.getLeft() != null) {
				
				curr = curr.getLeft();
			} else {
				
				break;
			}
		}
		
		return curr.getData();
	}
	
	@Override
	public String findMax() {
		
		BST_Node curr = getRoot();
		if(size == 0) {
			return null;
		}
		
		while(curr != null) {
			
			if(curr.getRight() != null) {
				
				curr = curr.findMax();
			} else {
				
				break;
			}
		}
		
		return curr.getData();
	}
	
	@Override
	public boolean empty() {
		if(root == null || size == 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean contains(String s) {
		BST_Node curr = root;
		
		while(curr != null) {
			
			if(s.compareTo(curr.getData()) == 0){
				
				return true;
			} else if(s.compareTo(curr.getData()) > 0){
				
				curr = curr.getRight();
			} else {
				
				curr = curr.getLeft();
			}
		}
		
		return false;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public int height() {
		if(root != null) {
			return getRoot().getHeight(root);
		} else {
			return -1;
		}
	}

}