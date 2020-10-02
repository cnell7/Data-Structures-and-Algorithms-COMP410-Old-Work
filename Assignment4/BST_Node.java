package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par;
	boolean justMade; 


	BST_Node(){
		this.justMade = false;
	}
	BST_Node(String data) {
		this.data = data;
		this.justMade = true;
	}

	BST_Node(String data, BST_Node left, BST_Node right, BST_Node par) { 
																			
		this.data = data;
		this.left = left;
		this.right = right;
		this.par = par;
		this.justMade = true;
	}

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}
	
	public boolean getJustMade() {
		return justMade;
	}

	public void makeLeftChildParent(BST_Node c, BST_Node p) {
		
        if (p.par != null)
        {
            if (p == p.par.left)
                p.par.left = c;
            else 
                p.par.right = c;
        }
        if (c.right != null)
            c.right.par = p;

        c.par = p.par;
        p.par = c;
        p.left = c.right;
        c.right = p;
    }

    public void makeRightChildParent(BST_Node c, BST_Node p) {

        if (p.par != null)
        {
            if (p == p.par.left)
                p.par.left = c;
            else
                p.par.right = c;
        }
        if (c.left != null)
            c.left.par = p;
        c.par = p.par;
        p.par = c;
        p.right = c.left;
        c.left = p;
    }
	private BST_Node splay(BST_Node toSplay) {
		if(toSplay.par == null) {
			
			return toSplay;
		}
		
		while (toSplay.par != null)
        {
            BST_Node Parent = toSplay.par;
            BST_Node GrandParent = Parent.par;
            if (GrandParent == null)
            {
                if (toSplay == Parent.left)
                    makeLeftChildParent(toSplay, Parent);
                else
                    makeRightChildParent(toSplay, Parent);                 
            } 
            else
            {
                if (toSplay == Parent.left)
                {
                    if (Parent == GrandParent.left)
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(toSplay, Parent);
                    }
                    else 
                    {
                        makeLeftChildParent(toSplay, toSplay.par);
                        makeRightChildParent(toSplay, toSplay.par);
                    }
                }
                else 
                {
                    if (Parent == GrandParent.left)
                    {
                        makeRightChildParent(toSplay, toSplay.par);
                        makeLeftChildParent(toSplay, toSplay.par);
                    } 
                    else 
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(toSplay, Parent);
                    }
                }
            }
        }
        return toSplay;
	}
	
	public BST_Node containsNode(String s){ 
		if(data.equals(s)) {
			splay(this);
			return this;
		}
		if(data.compareTo(s)>0){
			if(left==null)return new BST_Node();
			return left.containsNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null)return new BST_Node();
			return right.containsNode(s);
		}
		return null; 
	}
	public BST_Node insertNode(String s){
		if(data.compareTo(s)>0){
			if(left==null){
				BST_Node x = new BST_Node(s);
				this.left= x;
				x.par = this;
				splay(x);
				return x;
			}
			return left.insertNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null){
				BST_Node x = new BST_Node(s);
				this.right = x;
				x.par = this;
				splay(x);
				return x;
			}
			return right.insertNode(s);
		}
		return null;
	}
	public BST_Node removeNode(String s){ 
		BST_Node x = containsNode(s);
		splay(x);
		return x;
	}
	public BST_Node findMin(){
		if(left!=null)return left.findMin();
		splay(this);
		return this;
	}
	public BST_Node findMax(){
		if(right!=null)return right.findMax();
		splay(this);
		return this;
	}
	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}	
}