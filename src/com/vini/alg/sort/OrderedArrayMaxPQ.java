package com.vini.alg.sort;

import java.util.Arrays;

public class OrderedArrayMaxPQ<T extends Comparable<T>> {
	private final static int DEFAULT_SIZE = 5;
    private T[] pq;     
    private int N;        
    
    public OrderedArrayMaxPQ() {
    	this(DEFAULT_SIZE);
    }
    
    // set initial size of heap to hold size elements
    public OrderedArrayMaxPQ(int capacity) {
        pq = (T[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty()   { return N == 0; }
    public int size()          { return N; }
    
    public void insert(T key)  { 
    	ensureCapacity(N);
    	int i = N - 1;
    	while (i >= 0 && less(key, pq[i])) {
    		pq[i+1] = pq[i];
    		i--;
    	}
    	pq[i+1] = key;
    	N++;
    }

    public T delMax() {return pq[--N];  }
    
    private void ensureCapacity(int minCapacity) {
		int oldCapacity = pq.length;
		if (minCapacity+1 > oldCapacity) {
			Object oldData[] = pq;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			pq = Arrays.copyOf(pq, newCapacity);

		}	
    }

    private boolean less(T v, T w) {
        return (v.compareTo(w) < 0);
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static void main(String[] args) {
        OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>();
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		for (Integer i : a)
			pq.insert(i);
		
        while (!pq.isEmpty()) 
            System.out.println(pq.delMax());
    }

}
