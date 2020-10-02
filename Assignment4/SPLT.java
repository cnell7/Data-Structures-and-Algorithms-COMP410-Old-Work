package SPLT_A4;

public class SPLT implements SPLT_Interface {
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	public BST_Node getRoot() { 
		return root;
	}

	@Override
	public void insert(String s) { 
		if (empty()) {
			root = new BST_Node(s);
			size += 1;
		} else if (contains(s) == true) {

		} else {
			size += 1;
			root = root.insertNode(s);
		}
	}

	@Override
	public void remove(String s) { 

		BST_Node min;
		if (contains(s) == false) {
			contains(findMin());
		} else {
			if (root.data.equals(s) && size == 1) {
				root = null;
				size -= 1;
			} else {
				size -= 1;
				BST_Node x = root.removeNode(s);
				if ((x.left != null) && (x.right != null)) {

					if (x.left.right != null && x.right.left != null) {

						min = x.left;
						while (min.right != null)
							min = min.right;
						contains(min.getData());
						remove(min.right.getData());

					} else {
						
						min = x.left;
						while (min.right != null)
							min = min.right;

						min.right = x.right;
						x.right.par = min;
						x.left.par = null;
						root = x.left;
					}

				} else if (x.right != null) {
					x.right.par = null;
					root = x.right;
				} else if (x.left != null) {
					x.left.par = null;
					root = x.left;
				} else {
					root = null;
				}
				x.par = null;
				x.left = null;
				x.right = null;
				x = null;
			}
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			BST_Node x = root.findMin();
			root = x;
			return x.data;
		}
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			BST_Node x = root.findMax();
			root = x;
			return x.data;
		}
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (empty() || s == null) {
			return false;
		}

		BST_Node x = root.containsNode(s);
		if (x.getJustMade() == false) {
			return false;
		} else {
			root = x;
			return true;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}
}