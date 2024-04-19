package tv.codely.inventory.stocks.domain;

import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.shelves.domain.Shelf;
import tv.codely.shared.domain.AggregateRoot;

public final class Stock extends AggregateRoot {
	private final Product product;
	private final Shelf shelf;
	private StockAmount amount;

	public Stock(Product product, Shelf shelf, StockAmount amount) {
		this.product = product;
		this.shelf = shelf;
		this.amount = amount;
	}

	public Product product() {
		return product;
	}

	public Shelf shelf() {
		return shelf;
	}

	public StockAmount amount() {
		return amount;
	}
}
