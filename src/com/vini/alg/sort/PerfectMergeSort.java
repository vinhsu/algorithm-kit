package com.vini.alg.sort;

import java.lang.reflect.Array;

/**
 * basic merge sort and top down
 * @author vhsu
 *
 */
public class PerfectMergeSort {
	private static final int CUTOFF = 7;  // cutoff to insertion sort
	
	private PerfectMergeSort() {}
	
	private static <T> void merge(Comparable<T>[] src, Comparable<T>[] dst, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) dst[k] = src[j++];
			else if (j > hi) dst[k] = src[i++];
			else if (src[j].compareTo((T) src[i]) < 0) dst[k] = src[j++];
			else dst[k] = src[i++];				
		}		
	}
	
	private static <T> void sort(Comparable<T>[] src, Comparable<T>[] dst, int lo, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			insertionSort(dst, lo, hi);
			return;
		}
		
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);

        // if (!less(src[mid+1], src[mid])) {
        //    for (int i = lo; i <= hi; i++) dst[i] = src[i];
        //    return;
        // }

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        merge(src, dst, lo, mid, hi);
	}
	
    private static <T> void insertionSort(Comparable<T>[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
    
    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T> boolean less(Comparable<T> a, Comparable<T> b) {
        return (a.compareTo((T)b) < 0);
    }
    
	public static <T> void sort(Comparable<T>[] a) {
        Comparable<T>[] aux = a.clone();
        sort(aux, a, 0, a.length-1);  
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
