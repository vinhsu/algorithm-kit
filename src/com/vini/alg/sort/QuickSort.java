package com.vini.alg.sort;

public class QuickSort {

	private QuickSort() {}
	
	public static void sort(Comparable[] a) {
		Utility.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				if (i == hi) break;
			
			while (less(v, a[--j]))
				if (j == lo) break;
			
			if (i >= j) break;
			
			exch(a, i, j);
		}
		
		exch(a, lo, j);
		return j;
	}
	
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static Comparable select(Comparable[] a, int k) {
    	if (k<0 || k > a.length) {
    		throw new IndexOutOfBoundsException("Selected element out of bounds");
    	}
    	Utility.shuffle(a);
    	int lo = 0, hi = a.length - 1;
    	while (hi > lo) {
    		int i = partition(a, lo, hi);
    		if (i > k) hi = i - 1;
    		else if (i < k) lo = i + 1;
    		else return a[i];
    	}
    	return a[lo];
    }
    
	private static <T> void display(Comparable[] a) {
        for (Comparable i : a) {
            System.out.print(i+ ",");
        }
    }
	
	public static void main(String[] args) {
		System.out.println("QuickSort:");
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		
		System.out.println("before :");
		display(a);
		System.out.println();
		sort(a);
		System.out.println("\nafter:");
		display(a);
		
		System.out.println("\n\n----------------------------------");
		int k=5; //array index
		Comparable v =select(a, k);
		System.out.println("find kth smallest item, k="+(k+1)+", v="+v);
				
		System.out.println("\n\n----------------------------------");
		String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		System.out.println("before :");
		display(b);
		System.out.println();
		sort(b);
		System.out.println("\nafter:");
		display(b);
	}

}
