package dev.ivanhernandez.inventory.stocks.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;

import java.util.Objects;

public final class Stock {
	private final ShelfId shelfId;
	private final StockQuantity quantity;
	private final ProductId productId;

	public Stock(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		this.shelfId = shelfId;
		this.quantity = quantity;
		this.productId = productId;
	}

	private Stock() {
		this.shelfId = null;
		this.quantity = null;
		this.productId = null;
	}

	public static Stock create(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		if (quantity.value() < 0) {
			throw new IllegalArgumentException("The quantity must be greater than 0");
		}
		return new Stock(shelfId, quantity, productId);
	}

	public ShelfId shelfId() {
		return shelfId;
	}

	public StockQuantity quantity() {
		return quantity;
	}

	public ProductId productId() {
		return productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Stock stock = (Stock) o;
		return Objects.equals(this.shelfId, stock.shelfId) && Objects.equals(this.quantity, stock.quantity) && Objects.equals(this.productId, stock.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.shelfId, this.quantity, this.productId);
	}

	@Override
	public String toString() {
		return "Stock{" +
			"shelfId=" + shelfId +
			", quantity=" + quantity +
			", productId=" + productId +
			'}';
	}
}
