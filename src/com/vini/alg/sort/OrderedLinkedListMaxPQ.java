package com.vini.alg.sort;

public class OrderedLinkedListMaxPQ {
	private Node head;
	private int N;
	OrderedLinkedListMaxPQ() {
		head = null;
	}
	
    public boolean isEmpty()   { return N == 0; }
    public int size()          { return N; }
    public Node delMax() {
    	N--;
    	Node m = head;
    	head = head.next;
    	return m;
    }
    
    public void insert(Node k)  { 
    	Node prev = null;
    	Node current = head;
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
	
    private boolean less(Node v, Node w) {
        return (v.item.compareTo(w.item) < 0);
    }
    
	public static void main(String[] args) {
		OrderedLinkedListMaxPQ pq = new OrderedLinkedListMaxPQ();
		Integer[] a = {50, 34, 17, 99, 83, 246, 777, 13, 8, 57, 62};
		for (Integer i : a) {
			Node node = pq.new Node(i);
			pq.insert(node);
		}
		
		while (!pq.isEmpty()) 
	        System.out.println(pq.delMax());
	}

	class Node {
		Node next;
		Integer item;
		Node(Integer item) {
			this.item = item;
		}
		
		public String toString() {
			return item.toString();
		}
	}
}
