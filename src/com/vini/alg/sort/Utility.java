package com.vini.alg.sort;

import java.util.Comparator;
import java.util.Random;

public class Utility {
	
    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }


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

    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N-i);     // between i and N-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    
    public static int uniform(int N) {
        return random.nextInt(N);
    }
}
