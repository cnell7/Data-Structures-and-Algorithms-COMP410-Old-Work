package MinBinHeap_A3;

public class MinBinHeap_Playground {
	public static void main(String[] args) {
		// Add more tests as methods and call them here!!
		TestBuild();
	}

	public static void TestBuild() {
		// constructs a new minbinheap, constructs an array of EntryPair,
		// passes it into build function. Then print collection and heap.
		MinBinHeap mbh = new MinBinHeap();
		
		/*
		mbh.insert(new EntryPair("a", 5));
		mbh.insert(new EntryPair("b", 4));
		mbh.insert(new EntryPair("c", 3));
		mbh.insert(new EntryPair("d", 2));
		mbh.insert(new EntryPair("e", 1));
		*/
		
		mbh.insert(new EntryPair("a", 1));
		mbh.insert(new EntryPair("a", 2));
		mbh.insert(new EntryPair("a", 3));

		printHeap(mbh.getHeap(), mbh.size());
		mbh.delMin();
		printHeap(mbh.getHeap(), mbh.size());

		//EntryPair[] collection = new EntryPair[1];
		//mbh.build(collection);
		//printHeapCollection(collection);
		mbh.delMin();
		printHeap(mbh.getHeap(), mbh.size());
	}

	public static void printHeapCollection(EntryPair[] e) {
		// this will print the entirety of an array of entry pairs you will pass
		// to your build function.
		System.out.println("Printing Collection to pass in to build function:");
		for (int i = 0; i < e.length; i++) {
			System.out.print("(" + e[i].value + "," + e[i].priority + ")\t");
		}
		System.out.print("\n");
	}

	public static void printHeap(EntryPair[] e, int len) {
		// pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th
		// index....
		System.out.println("Printing Heap");
		for (int i = 1; i < len + 1; i++) {
			System.out.print("(" + e[i].value + "," + e[i].priority + ")\t");
		}
		System.out.print("\n");
	}
}