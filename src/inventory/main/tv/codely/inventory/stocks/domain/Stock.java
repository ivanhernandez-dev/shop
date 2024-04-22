package tv.codely.inventory.stocks.domain;

import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.shelves.domain.Shelf;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Stock extends AggregateRoot {
	private final Product product;
	private final Shelf shelf;
	private final StockAmount amount;

	public Stock(Product product, Shelf shelf, StockAmount amount) {
		this.product = product;
		this.shelf = shelf;
		this.amount = amount;
	}

	public Stock() {
		this.product = null;
		this.shelf = null;
		this.amount = null;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Stock stock = (Stock) o;
		return Objects.equals(this.product, stock.product) && Objects.equals(this.shelf, stock.shelf) && Objects.equals(this.amount, stock.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.product, this.shelf, this.amount);
	}
}
