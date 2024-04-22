package tv.codely.inventory.stocks.domain;

import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductMother;
import tv.codely.inventory.shelves.domain.Shelf;
import tv.codely.inventory.shelves.domain.ShelfMother;

public final class StockMother {
	public static Stock create(Product product, Shelf shelf, StockAmount amount) {
		return new Stock(product, shelf, amount);
	}

	public static Stock random() {
		return create(ProductMother.random(), ShelfMother.random(), StockAmountMother.random());
	}
}
