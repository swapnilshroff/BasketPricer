package example.pricing;

import example.pricing.domain.Item;

public interface ItemPriceCalculator {
	
	double calculatePrice(Item item, int quantity);
	
}
