package com.vini.alg.sort;

/**
 * index merge sort to save copy object[] (a) space by using int[] (index)
 * @author vhsu
 *
 */
public class IndexMergeSort {
	
	private IndexMergeSort() {}
	
	private static <T> void merge(Comparable<T>[] a, int[] index, int[] aux, int lo, int mid, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = index[k];
		
		// merge back to a[]
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) index[k] = aux[j++];
			else if (j > hi) index[k] = aux[i++];
			else if (a[aux[j]].compareTo((T) a[aux[i]]) < 0) index[k] = aux[j++];
			else index[k] = aux[i++];				
		}		
	}
	
	private static <T> void sort(Comparable<T>[] a, int[] index, int[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, index, aux, lo, mid);
		sort(a, index, aux, mid+1, hi);
		merge(a, index, aux, lo, mid, hi);
	}
	
	public static <T> int[] indexSort(Comparable<T>[] a) {
		int N = a.length;
		int[] index = new int[N];
		for (int i=0 ; i<N ; i++)
			index[i] = i;
		
		int[] aux = new int[N];
		sort(a, index, aux, 0, N-1);
		
		return index;	
	}
	
	private static <T> void display(Comparable<T>[] a) {		
		for (Comparable<T> x : a) 
			System.out.print(" "+x);
	}

	private static <T> void show(Comparable<T>[] a, int[] index) {		
		for (int i=0; i<index.length; i++) 
			System.out.print(" "+a[index[i]]);
	}
	
	public static void main(String[] args) {
		String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		System.out.println("before: ");
		display(a);
		System.out.println();
		System.out.println("after :");
		show(a, indexSort(a));
		System.out.println();
		
		System.out.println("---------------------------------");
		Integer[] b = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		System.out.println("before: asc");
		display(b);
		System.out.println();
		System.out.println("after :");
		show(b, indexSort(b));
		System.out.println();
		
		System.out.println("---------------------------------");
		Item[] c = new Item[5];
		c[0] = new Item(100,"pen",3);
		c[1] = new Item(200,"bucket",75);
		c[2] = new Item(300,"cabon",17);
		c[3] = new Item(400,"fruit",27);
		c[4] = new Item(500,"nugget",150);
		System.out.println("before: ");
		display(c);
		System.out.println();
		System.out.println("after :");
		show(c, indexSort(c));
		System.out.println();
	}
}
