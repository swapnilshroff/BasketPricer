package example.pricing.test;

import static org.junit.Assert.*;

import org.junit.Test;

import example.pricing.ItemPriceCalculator;
import example.pricing.SimplePriceCalculator;
import example.pricing.domain.Item;

public class SimplePriceCalculatorTest {

	private ItemPriceCalculator priceCalculation = new SimplePriceCalculator();

	@Test public void
	should_return_item_price_when_quantity_is_one() {
		Item fruit = new Item("Orange",10);

		double price = priceCalculation.calculatePrice(fruit, 1);

		assertTrue("should_return_item_price_when_quantity_is_one failed", price == 10.0);
	}

	@Test public void
	should_return_item_price_multiplied_by_quantity() {
		Item fruit = new Item("Orange",10);

		double price = priceCalculation.calculatePrice(fruit, 3);

		assertTrue("should_return_item_price_when_quantity_is_one failed", price == 30.0);
	}

	@Test public void
	should_return_zero_when_quantity_is_zero() {
		Item fruit = new Item("Orange",10);

		double price = priceCalculation.calculatePrice(fruit, 0);

		assertTrue("should_return_item_price_when_quantity_is_one failed", price == 0);
	}

}
