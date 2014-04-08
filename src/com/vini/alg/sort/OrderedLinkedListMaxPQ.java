package com.vini.alg.sort;

public class OrderedLinkedListMaxPQ<T extends Comparable<T>> {
	private Node<T> head;
	private int N;
	OrderedLinkedListMaxPQ() {
		head = null;
	}
	
    public boolean isEmpty()   { return N == 0; }
    public int size()          { return N; }
    public Node<T> delMax() {
    	N--;
    	Node<T> max = head;
    	head = head.next;
    	return max;
    }
    
    public void insert(Node<T> k)  { 
    	Node<T> prev = null;
    	Node<T> current = head;
    	while(current != null && less(k, current))
        {
    		prev = current;
            current = current.next;
        }
        if(prev == null)
            head = k;
        else 
            prev.next = k;
        k.next = current;
        N++;
    }
	
    private boolean less(Node<T> v, Node<T> w) {
        return (v.val.compareTo(w.val) < 0);
    }
    
	public static void main(String[] args) {
		OrderedLinkedListMaxPQ<Integer> pq = new OrderedLinkedListMaxPQ<Integer>();
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		for (Integer val : a) {
			pq.insert(new Node<Integer>(val));
		}
		
		while (!pq.isEmpty()) 
	        System.out.print(pq.delMax() + ", ");
		
		System.out.println("\n---------------------------------");
		 
		OrderedLinkedListMaxPQ<String> pq2 = new OrderedLinkedListMaxPQ<String>();
		String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		for (String val : b) {
			pq2.insert(new Node<String>(val));
		}
		
		while (!pq2.isEmpty()) 
	        System.out.print(pq2.delMax() + ", ");
	}

	static class Node<T extends Comparable<T>> {
		Node<T> next;
		T val;
		Node(T val) {
			this.val = val;
		}
		
		public String toString() {
			return val.toString();
		}
	}
}
