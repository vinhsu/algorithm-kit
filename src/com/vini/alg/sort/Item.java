package com.vini.alg.sort;

public final class Item implements Comparable<Item>{
	private int id;
	private String name;
	private int price;
	
	Item(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public int compareTo(Item other) {
		if (this.price > other.price)
			return 1;
		else if (this.price < other.price)
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "[Id="+this.id+", name="+this.name+", size="+this.price+"]";
	}
}