package com.vini.alg.sort;

import java.lang.reflect.Array;

/**
 * merge sort and sorting order
 * @author vhsu
 *
 */
public class MergeSort2 {
	//default true, order by ascending
	static boolean ASCENDING = true;
	
	private MergeSort2() {}
	
	private static <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		// merge back to a[]
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (compare(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];				
		}		
	}
	
	private static <T> void sort(Comparable<T>[] a, Comparable<T>[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static <T> void sort(Comparable<T>[] a, boolean asc) {
		ASCENDING = asc;
		@SuppressWarnings("unchecked")
		Comparable<T>[] aux = (Comparable<T>[])Array.newInstance(Comparable.class, a.length);
		sort(a, aux, 0, a.length-1);		
	}
	
	private static <T> void display(Comparable<T>[] a) {		
		for (Comparable<T> x : a) 
			System.out.print(" "+x);
	}

	private static <T> boolean compare(Comparable<T> x, Comparable<T> y) {
		if (ASCENDING)
			return x.compareTo((T) y) < 0;
		else
			return x.compareTo((T) y) > 0;
	}
	
	public static void main(String[] args) {
		System.out.println("---------------------------------");
		Integer[] b = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		System.out.println("before: asc");
		display(b);
		sort(b, true);
		System.out.println();
		System.out.println("after :");
		display(b);
		System.out.println();
		
		System.out.println("---------------------------------");
		Integer[] b2 = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		System.out.println("before: desc");
		display(b2);
		sort(b2, false);
		System.out.println();
		System.out.println("after :");
		display(b2);
		System.out.println();
	}
}
