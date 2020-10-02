/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the head)
    int size = 0;

	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part of your data set!
	}

	// implement all methods in interface, and include the getRoot method we made
	// for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		
		Node curr = sentinel.getNext();
		Node temp = new Node(elt);
		int count = 0;
		
		if(index > size || index < 0) {
			
			return false;
		} else if(isEmpty()) {
			
			temp.next = sentinel;
			temp.prev = sentinel;
			sentinel.next = temp;
			sentinel.prev = temp;
			size++;
			return true;
		}
		
		while(curr != sentinel) {
			
			if(count < index) {
				
				count++;
				curr = curr.getNext();
			} else {
				
				break;
			}
		}
		
		temp.prev = curr.getPrev();
		temp.next = curr;
		curr.getPrev().next = temp;
		curr.prev = temp;
		size++;
		return true;
			
}

	@Override
	public boolean remove(int index) {
		
		Node curr = sentinel.getNext();
		int count = 0;
		
		if(index >= size || index < 0) {
			
			return false;
		} else if(isEmpty()) {
			
			return false;
		}
		
		while(curr != sentinel) {
			if(count < index) {
				
				count++;
				curr = curr.getNext();
			} else {
				
				break;
			}
		}
		curr.getPrev().next = curr.getNext();
		curr.getNext().prev = curr.getPrev();
		size--;
		return true;
	}

	@Override
	public double get(int index) {
		
		Node curr = sentinel.getNext();
		int count = 0;
		
		if(isEmpty()) {
			
			return Double.NaN;
		}
		
		if(index > size) {
			
			return Double.NaN;
		}
		
		while(curr != sentinel) {
			
			if(count == index) {
				
				return curr.getData();
			} else {
				
				curr = curr.getNext();
				count++;
			}
		}
		
		return Double.NaN;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(sentinel.getNext() == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		sentinel.next = null;
		sentinel.prev = null;
		size = 0;
		
	}
}