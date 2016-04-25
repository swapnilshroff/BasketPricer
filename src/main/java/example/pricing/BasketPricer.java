package example.pricing;

public class BasketPricer {
	
	private ItemPriceCalculator priceCalculator;
	
	public BasketPricer(ItemPriceCalculator priceCalculator){
		this.priceCalculator = priceCalculator;
	}
	
	public double calcualteBasketPrice(Basket basket) {
        double total = 0;
        for (Basket.BasketElement e : basket.elements()) {
            total += priceCalculator.calculatePrice(e.getItem(), e.getQuantity());
        }
        return total;
    }
}
