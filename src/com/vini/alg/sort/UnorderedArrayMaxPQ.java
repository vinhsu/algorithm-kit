package com.vini.alg.sort;

import java.util.Arrays;

public class UnorderedArrayMaxPQ<T extends Comparable<T>> {
    private T[] pq;     
    private int N;        
    
    // set initial size of heap to hold size elements
    public UnorderedArrayMaxPQ(int capacity) {
        pq = (T[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty()   { return N == 0; }
    public int size()          { return N;      }
    
    public void insert(T x)  { 
    	ensureCapacity(N);
    	pq[N++] = x;  
    }

    public T delMax() {
    	int max = 0;
    	for (int i = 1; i < N; i++) 
    		if (less(max, i)) max = i;
    	
    	exch(max, N-1);
    	return pq[--N];
    }
    
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

    private boolean less(int i, int j) {
        return (pq[i].compareTo(pq[j]) < 0);
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>(5);
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		for (Integer i : a)
			pq.insert(i);
		
        while (!pq.isEmpty()) 
            System.out.println(pq.delMax());
    }

}
