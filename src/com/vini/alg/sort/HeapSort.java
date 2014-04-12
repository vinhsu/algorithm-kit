package com.vini.alg.sort;


public class HeapSort {
	
    private HeapSort() { }
    
    //Rearranges the array in ascending order, using the natural order.
    public static <T> void sort(Comparable<T>[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    private static <T> void sink(Comparable<T>[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /**
	 * change to descending order
     */
    /* private static <T> void sink(Comparable<T>[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && !less(pq, j, j+1)) j++;
            if (less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }*/
    
    private static <T> boolean less(Comparable<T>[] pq, int i, int j) {
        return pq[i-1].compareTo((T)pq[j-1]) < 0;
    }

    private static <T> void exch(Comparable<T>[] pq, int i, int j) {
        Comparable<T> swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static <T> void show(Comparable<T>[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
    }

    public static void main(String[] args) {
        int size = 10;
        Long[] a = new Long[size];
        int i = 0;
        while (i < 10) {
        	a[i++] = Math.round(Math.random() * 100);        	
        }
        HeapSort.sort(a);
        show(a);
    }
}
