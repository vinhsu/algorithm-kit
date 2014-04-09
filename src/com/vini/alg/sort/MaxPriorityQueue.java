package com.vini.alg.sort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPriorityQueue<T> {
	private T[] pq;
	private int N;
	private Comparator<T> comparator;
	private T min;
	
	public MaxPriorityQueue() {
		this(1);
	}
	
    public MaxPriorityQueue(int initCapacity) {
        pq = (T[]) new Object[initCapacity + 1];
        N = 0;
    }
	
    public MaxPriorityQueue(int initCapacity, Comparator<T> cmp) {
    	this(initCapacity);
    	this.comparator = cmp;
    }
    
    public MaxPriorityQueue(T[] keys) {
    	N = keys.length;
    	pq = (T[]) new Object[keys.length + 1];
    	for (int i = 0; i < N; i++)
    		pq[i+1] = keys[i];
    	
    	for (int k=N/2; k >= 1; k--)
    		sink(k);
    }

    public boolean isEmpty()   { return N == 0; }
    public int size()          { return N; }
    
    public T getMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    
    public T getMin() {
    	if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
    	return min;
    }
    
    public void insert(T x) {
        if (N >= pq.length - 1) resize(pq.length*3/2);
        pq[++N] = x;
        if (min == null || ((Comparable<T>) x).compareTo(min) < 0)
        	min = x;   
        swim(N);
    }
    
    public T delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        T max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;     
        // to avoid loiterig and help with garbage collection
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }
    
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= N; i++) temp[i] = pq[i];
        pq = temp;
    }
    
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && less(k, left))  return false;
        if (right <= N && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
    
	public static void main(String[] args) {
		MaxPriorityQueue<String> pq = new MaxPriorityQueue<String>();
		String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		for (String x : a) 
			pq.insert(x);
		
		while (!pq.isEmpty()){
			String m = pq.delMax();
			System.out.print(m + ", ");
		}

		System.out.println("\n\n----------------------------------");
		MaxPriorityQueue<Integer> pq2 = new MaxPriorityQueue<Integer>(20,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.intValue() - o2.intValue();
					}
			
				});
		Integer[] b = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		for (Integer x : b) 
			pq2.insert(x);
		
		System.out.println("min is " + pq2.getMin());
		
		while (!pq2.isEmpty()){
			Integer m = pq2.delMax();
			System.out.print(m + ", ");
		}
	}

}
