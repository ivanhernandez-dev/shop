package dev.ivanhernandez.inventory.stocks.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.AggregateRoot;
import dev.ivanhernandez.shared.domain.stock.StockCreatedDomainEvent;
import dev.ivanhernandez.shared.domain.stock.StockDeletedDomainEvent;
import dev.ivanhernandez.shared.domain.stock.StockUpdatedDomainEvent;

import java.util.Objects;

public final class Stock extends AggregateRoot {
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
		Stock stock = new Stock(shelfId, quantity, productId);
		stock.record(new StockCreatedDomainEvent(productId.value(), productId.value(), shelfId.value(), quantity.value()));
		return stock;
	}

	public static Stock update(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		if (quantity.value() < 0) {
			throw new IllegalArgumentException("The quantity must be greater than 0");
		}
		Stock stock = new Stock(shelfId, quantity, productId);
		stock.record(new StockUpdatedDomainEvent(productId.value(), productId.value(), shelfId.value(), quantity.value()));
		return stock;
	}

	public static Stock delete(ShelfId shelfId, ProductId productId) {
		Stock stock = new Stock(shelfId, null, productId);
		stock.record(new StockDeletedDomainEvent(productId.value(), productId.value(), shelfId.value()));
		return stock;
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
