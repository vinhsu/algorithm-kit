package com.vini.alg.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * basic merge sort and decouple by comparator
 * @author vhsu
 *
 */
public class ComparatorMergeSort {
	
	private ComparatorMergeSort() {}
	
	private static void merge(Object[] a, Object[] aux, int lo, int mid, int hi, Comparator comparator) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		// merge back to a[]
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if  (less(comparator, aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];				
		}		
	}
	
	private static void sort(Object[] a, Object[] aux, int lo, int hi, Comparator comparator) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid, comparator);
		sort(a, aux, mid+1, hi, comparator);
		//efficiency
		if (!less(comparator, a[mid+1],  a[mid])) return; //see PerfectMergeSort.java
		merge(a, aux, lo, mid, hi, comparator);
	}
	
	public static <T> void sort(Object[] a, Comparator comparator) {		
		@SuppressWarnings("unchecked")
		Comparable<T>[] aux = (Comparable<T>[])Array.newInstance(Comparable.class, a.length);
		sort(a, aux, 0, a.length-1, comparator);
	}
	
    private static boolean less(Comparator c, Object v, Object w) {
        return (c.compare(v, w) < 0);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
	private static <T> void display(Comparable<T>[] a) {		
		for (Comparable<T> x : a) 
			System.out.print(" "+x);
	}

	public static void main(String[] args) {
		String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		System.out.println("before: ");
		display(a);
		sort(a, new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println();
		System.out.println("after :");
		display(a);
		System.out.println();
		
		System.out.println("---------------------------------");
		Integer[] b = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		System.out.println("before: asc");
		display(b);
		sort(b, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
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
		sort(c, new Comparator<Item>(){
			public int compare(Item o1, Item o2) {
				return Integer.valueOf(o1.getPrice()).compareTo(Integer.valueOf(o2.getPrice()));
			}
		});
		System.out.println();
		System.out.println("after :");
		display(c);
		System.out.println();
	}
}
