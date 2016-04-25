package example.pricing.test;

import java.util.HashMap;
import java.util.Map;

import example.pricing.Basket;
import example.pricing.BasketPricer;
import example.pricing.SimplePriceCalculator;
import example.pricing.domain.Item;

public class BasketPricingTest {
	
	static Map<String, Item> fruits = new HashMap<String, Item>();
	

	public static void main(String[] args) throws Exception {

		if(args.length < 2 ||args.length%2 != 0){
			throw new Exception("Incorrect Basket " + args.length);
		}
		
		setPricesForFruits();
		
		Basket basket = getBasket(args);
		
		BasketPricer pricer = new BasketPricer(new SimplePriceCalculator());
		
		double totalCost = pricer.calcualteBasketPrice(basket);
		
		System.out.println(" Total cost of basket " + basket + "\n is " + totalCost);

	}

	private static void setPricesForFruits() {
		fruits.put("Banana", new Item("Banana", 10));
		fruits.put("Orange", new Item("Orange", 20));
		fruits.put("Apple", new Item("Apple", 30));
		fruits.put("Lemon", new Item("Lemon", 40));
		fruits.put("Peach", new Item("Peach", 50));
	}

	private static Basket getBasket(String[] args) {
		
		Basket basket = new Basket();
		for (int i = 0; i < args.length; i=i+2) {
			Item item = getItem(args[i]);
			int qty = getQty(args[i+1]);
			if(item==null || qty == 0){
				System.out.println("Invalid item or quantity " + args[i] + args[i+1]);
				continue;
			}
			basket.add(item, qty);
		}
		return basket;
	}

	private static int getQty(String quantity) {
		try{
			int qty = Integer.parseInt(quantity);
			return qty;
		}catch(NumberFormatException e){
			return 0;
		}
	}

	private static Item getItem(String fruit) {
		return fruits.get(fruit);
	}

}
