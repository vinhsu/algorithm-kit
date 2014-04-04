package com.vini.alg.sort;

public class QuicksortBest {
	private static final int CUTOFF = 8;
	
	private QuicksortBest() {}
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
    private static void sort(Comparable[] a, int lo, int hi) { 
        int N = hi - lo + 1;

        // cutoff to insertion sort
        if (N <= CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        // use median-of-3 as partitioning element
        else if (N <= 40) {
            int m = median3(a, lo, lo + N/2, hi);
            exch(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            int eps = N/8;
            int mid = lo + N/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi); 
            int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && eq(a[i], v))
                exch(a, ++p, i);
            if (i >= j) break;

            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++) exch(a, k, j--);
        for (int k = hi; k >= q; k--) exch(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }

		
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
    
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    private static boolean eq(Comparable v, Comparable w) {
        return (v.compareTo(w) == 0);
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
		String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		System.out.println("before :");
		display(b);
		System.out.println();
		sort(b);
		System.out.println("\nafter:");
		display(b);
	}

}
