package com.vini.alg.sort;

public class Quicksort3way {

	private Quicksort3way() {}
	
	public static void sort(Comparable[] a) {
		Utility.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		
		int lt = lo, gt = hi;
		Comparable v = a[lo];
		int i = lo;
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) exch(a, lt++, i++);
			else if (cmp > 0) exch(a, i, gt--);
			else i++;
		}
		
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
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
      
	private static <T> void display(Comparable[] a) {
        for (Comparable i : a) {
            System.out.print(i+ ",");
        }
    }
	
	public static void main(String[] args) {
		System.out.println("QuickSort 3 way:");
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		
		System.out.println("before :");
		display(a);
		System.out.println();
		sort(a);
		System.out.println("\nafter:");
		display(a);

		System.out.println("\n\n----------------------------------");
		String[] b = {"S", "O", "R", "T", "E", "R", "A", "M", "R", "P", "L", "E", "R"};
		System.out.println("before :");
		display(b);
		System.out.println();
		sort(b);
		System.out.println("\nafter:");
		display(b);
	}

}
