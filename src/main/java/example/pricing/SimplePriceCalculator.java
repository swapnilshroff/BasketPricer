package example.pricing;

import example.pricing.domain.Item;

public class SimplePriceCalculator implements ItemPriceCalculator {

	public double calculatePrice(Item item, int quantity) {
		return item.getPrice()*quantity;
	}

}
