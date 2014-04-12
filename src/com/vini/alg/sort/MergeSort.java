package com.vini.alg.sort;

import java.lang.reflect.Array;

/**
 * basic merge sort and top down
 * @author vhsu
 *
 */
public class MergeSort {
	
	private MergeSort() {}
	
	private static <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		// merge back to a[]
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (aux[j].compareTo((T) aux[i]) < 0) a[k] = aux[j++];
			else a[k] = aux[i++];				
		}		
	}
	
	private static <T> void sort(Comparable<T>[] a, Comparable<T>[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		//efficiency
		if (!less(a[mid+1], a[mid])) return; //see PerfectMergeSort.java
		merge(a, aux, lo, mid, hi);
	}
	
	public static <T> void sort(Comparable<T>[] a) {
		//Comparable[] aux = new Comparable[a.length];
		@SuppressWarnings("unchecked")
		Comparable<T>[] aux = (Comparable<T>[])Array.newInstance(Comparable.class, a.length);
		sort(a, aux, 0, a.length-1);		
	}
	
    private static <T> boolean less(Comparable<T> a, Comparable<T> b) {
        return (a.compareTo((T)b) < 0);
    }
    
	private static <T> void display(Comparable<T>[] a) {		
		for (Comparable<T> x : a) 
			System.out.print(" "+x);
	}

	
	public static void main(String[] args) {
		String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		System.out.println("before: ");
		display(a);
		sort(a);
		System.out.println();
		System.out.println("after :");
		display(a);
		System.out.println();
		
		System.out.println("---------------------------------");
		Integer[] b = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		System.out.println("before: asc");
		display(b);
		sort(b);
		System.out.println();
		System.out.println("after :");
		display(b);
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
		sort(c);
		System.out.println();
		System.out.println("after :");
		display(c);
		System.out.println();
	}
}
