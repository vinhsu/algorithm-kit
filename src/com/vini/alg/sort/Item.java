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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[Id="+this.id+", name="+this.name+", price="+this.price+"]";
	}
}