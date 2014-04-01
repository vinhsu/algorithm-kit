package com.vini.alg.sort;

import java.util.Comparator;

public class Utility {
	
	public static final Comparator ICOMPARATOR = new IComparator();
	
	
	public static class IComparator<T extends Comparable<T>> implements Comparator<T>{
		@Override
		public int compare(T x, T y) {
			return x.compareTo(y);
		}		
	}
	
	public static <T> Comparator<T> reverseOrder(Comparator<T> cmp) {
		return new ReverseComparator<T>(cmp);
	}
	
	public static class ReverseComparator<T> implements Comparator<T>{
		final Comparator<T> cmp;
		ReverseComparator(Comparator<T> cmp) {
			this.cmp = cmp;
		}
		
		@Override
		public int compare(T x, T y) {
			return cmp.compare(y, x);
		}
		
		public boolean equals(Object o) {
			return (o == this) || (o instanceof ReverseComparator &&
					cmp.equals(((ReverseComparator)o).cmp));
		}

		public int hashCode() {
			return cmp.hashCode() ^ Integer.MIN_VALUE;
		}
	}

}
