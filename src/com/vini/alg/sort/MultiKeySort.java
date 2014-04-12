package com.vini.alg.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MultiKeySort {

	public static void main(String[] args) {		
		@SuppressWarnings("unchecked")
		ChainedComparator cc = new ChainedComparator(ItemComparator.ID_SORT, ItemComparator.NAME_SORT);
		
		Item[] items = new Item[7];
		items[0] = new Item(100,"pen",3);
		items[1] = new Item(300,"cabon",17);
		items[2] = new Item(200,"bucket",75);
		items[3] = new Item(400,"fruit",27);
		items[4] = new Item(500,"nugget",150);
		items[5] = new Item(100,"cabon",54);
		items[6] = new Item(100,"ipod",72);
		
		Arrays.sort(items, cc);
		for (Item item : items)
			System.out.println(item);
	}
	
	enum ItemComparator implements Comparator<Item> {		
	    ID_SORT {
	        public int compare(Item o1, Item o2) {
	            return Integer.valueOf(o1.getId()).compareTo(o2.getId());
	        }},
	    NAME_SORT {
	        public int compare(Item o1, Item o2) {
	            return o1.getName().compareTo(o2.getName());
	        }};	
	}

    public static class ChainedComparator<T> implements Comparator<T> {
        private List<Comparator<T>> simpleComparators; 
        
        public ChainedComparator(Comparator<T>... simpleComparators) {
            this.simpleComparators = Arrays.asList(simpleComparators);
        }
        
        public int compare(T o1, T o2) {
            for (Comparator<T> comparator : simpleComparators) {
                int result = comparator.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }
    }
}
