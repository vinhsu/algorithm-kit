package com.vini.alg.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class SelectionSort {

	private SelectionSort() {}
	
	public static <T> void sort(List<T> list, Comparator<? super T> c) {
		Object[] a = list.toArray();
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(c, a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
		//write back
		ListIterator<T> i = list.listIterator();
		for (int j = 0; j < N; j++) {
			i.next();
			i.set((T) a[j]);
		}
	}
	
	private static boolean less(Comparator c, Object v, Object w) {
		return (c.compare(v, w) < 0);
	}
	
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static <T> void display(List<T> list) {
        for (T i : list) {
            System.out.print(i+ ",");
        }
    }
	
	public static void main(String[] args) {
		System.out.println("SelectionSort:");
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		List<Integer> x = Arrays.asList(a);
		
		Comparator c =  Utility.ICOMPARATOR;
		System.out.println("before :");
		display(x);
		System.out.println();
		sort(x, c);
		System.out.println("\nafter ascending :");
		display(x);
		System.out.println();
		sort(x, Utility.reverseOrder(c));
		System.out.println("\nafter descending :");
		display(x);
		
		System.out.println("\n\n----------------------------------");
		String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		List<String> y = Arrays.asList(b);
		System.out.println("before :");
		display(y);
		System.out.println();
		sort(y, c);
		System.out.println("\nafter ascending :");
		display(y);
		System.out.println();
		sort(y, Utility.reverseOrder(c));
		System.out.println("\nafter descending :");
		display(y);
	}
}
