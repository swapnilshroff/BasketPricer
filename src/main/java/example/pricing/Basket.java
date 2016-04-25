package example.pricing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import example.pricing.domain.Item;

public class Basket {
	
	   private Map<Item, AtomicInteger> basket = new ConcurrentHashMap<Item, AtomicInteger>();
	    
	    public void add(Item item, int quantity) {
	        basket.putIfAbsent(item, new AtomicInteger(0));
	        basket.get(item).getAndAdd(quantity);
	    }

	    public Collection<BasketElement> elements() {
	        Collection<BasketElement> elements = new ArrayList<BasketElement>();
	        for (Map.Entry<Item, AtomicInteger> basketEntry : basket.entrySet()) {
	        	elements.add(new BasketElement(basketEntry.getKey(), basketEntry.getValue().intValue()));
	        }
	        return elements;
	    }
	    
	    public static class BasketElement {

	        private Item item;
	        private Integer quantity;

	        public BasketElement(Item item, Integer quantity) {
	            this.item = item;
	            this.quantity = quantity;
	        }

	        public Item getItem() {
	            return this.item;
	        }

	        public Integer getQuantity() {
	            return this.quantity;
	        }
	        
	    }

		@Override
		public String toString() {
			String str ="";
			for (Item i : basket.keySet()) {
				str = str + "\n Item:" + i.getName() + " Price:" + i.getPrice() + " Qty:" + basket.get(i); 
			}
			return str;
		}
	    
	    

}
