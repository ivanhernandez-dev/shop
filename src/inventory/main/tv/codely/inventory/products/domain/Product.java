package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.AggregateRoot;

import java.math.BigDecimal;
import java.util.Objects;

public final class Product extends AggregateRoot {
	private final ProductId id;
	private final ProductName name;
	private final ProductPrice price;

	public Product(ProductId id, ProductName name, ProductPrice price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	private Product() {
		id = null;
		name = null;
		price = null;
	}

	public static Product create(ProductId id, ProductName name, ProductPrice price) {
		return new Product(id, name, price);
	}

	public ProductId id() {
		return id;
	}

	public ProductName name() {
		return name;
	}

	public ProductPrice price() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}
}
