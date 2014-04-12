package com.vini.alg.sort;

public class QuicksortDualPivot {

	private QuicksortDualPivot() {}
	
	public static void sort(Comparable[] a) {
		Utility.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		
		if (less(a[hi], a[lo]))	exch(a, lo, hi);
		
		int lt = lo + 1, gt = hi - 1;
		int i = lo + 1;
		while (i <= gt) {
			if (less(a[i], a[lo])) exch(a, lt++, i++);
			else if (less(a[hi], a[i])) exch(a, i, gt--);
			else i++;
		}
		exch(a, lo, --lt);
		exch(a, hi, ++gt);
		
		sort(a, lo, lt-1);
		if (less(a[lt], a[gt])) sort(a, lt+1, gt-1);
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
		System.out.println("QuickSort dual pivot:");
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
