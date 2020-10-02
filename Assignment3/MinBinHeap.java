package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size;
	private static final int arraySize = 10000; // Everything in the array will initially
												// be null. This is ok! Just build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for simplicity
													// of child/parent computations...
													// the book/animation page both do this.
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		
		EntryPair temp;
		Boolean done = true;
		size++;
		int i = this.size;
		
		while(done) {
			
			if(size == 1) {
				
				this.array[1] = entry;
				break;
			}
			
			if(entry.getPriority() < this.array[i / 2].getPriority()) {
				
				temp = this.array[i / 2];
				this.array[i / 2] = entry;
				this.array[i] = temp;
				i = i / 2;
			} else {
				
				this.array[i] = entry;
				done = false;
			}
		}
	}

	@Override
	public void delMin() {
		
		Boolean done = true;
		EntryPair temp;
		int i = 1;
		this.array[1] = this.array[size];
		this.array[size] = null;
		size--;
		
		while(done) {
			
			if(this.array[i * 2] == null &&
					this.array[(i * 2) + 1] == null) {
				
				break;
			}
			
			if(this.array[(i * 2) + 1] == null && 
					this.array[i].getPriority() > this.array[i * 2].getPriority()) {
				
				temp = this.array[i];
				this.array[i] = this.array[i * 2];
				this.array[i * 2] = temp;
				i = i * 2;
				
			} else if(this.array[(i * 2) + 1] == null && 
					this.array[i].getPriority() < this.array[i * 2].getPriority()) {
				
				break;
				
			} else if(this.array[i].getPriority() < this.array[i * 2].getPriority() && 
					this.array[i].getPriority() < this.array[(i * 2) + 1].getPriority()) {
				
				break;
			} else if(this.array[i * 2].getPriority() < this.array[(i * 2) + 1].getPriority()) {
				
				if(this.array[i].getPriority() > this.array[i * 2].getPriority()){
					
					temp = this.array[i];
					this.array[i] = this.array[i * 2];
					this.array[i * 2] = temp;
					i = i * 2;
				} else {
					
					break;
				}
			} else {
				if(this.array[i].getPriority() > this.array[(i * 2) + 1].getPriority()){
					
					temp = this.array[i];
					this.array[i] = this.array[(i * 2) + 1];
					this.array[(i * 2) + 1] = temp;
					i = (i * 2) + 1;
				} else {
					
					break;
				}
			}
		}
		
	}

	@Override
	public EntryPair getMin() {
		if(this.array[1] == null) {
			
			return null;
		} else {
			
			return this.array[1];
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		
		int count = 0;
		EntryPair temp;
		
		for(int i = 1; i < entries.length + 1; i++) {
			
			this.array[i] = entries[count];
			count++;
			this.size++;
		}
		
		for(int i = entries.length; i > 1; i--) {
			
			if(this.array[i].getPriority() < this.array[i/2].getPriority()) {
				
				temp = this.array[i/2];
				this.array[i/2] = this.array[i];
				this.array[i] = temp;
				
				
				if(i == 2) {
					
					//lChild
					if(this.array[2].getPriority() > this.array[4].getPriority()) {
						
						temp = this.array[2];
						this.array[2] = this.array[4];
						this.array[4] = temp;
					}
					//rChild
					if(this.array[2].getPriority() > this.array[5].getPriority()) {
						
						temp = this.array[2];
						this.array[2] = this.array[4];
						this.array[4] = temp;
					}
				}
			}
		}
	}
}
