package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.product.ProductCreatedDomainEvent;

import java.math.BigDecimal;
import java.util.Objects;

public final class Product extends AggregateRoot {
	private final ProductId id;
	private final ProductName name;
	private final ProductDescription description;
	private final ProductPrice price;
	private final ProductWeight weight;

	private Product() {
		this.id = null;
		this.name = null;
		this.description = null;
		this.price = null;
		this.weight = null;
	}

	public Product(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weight = weight;
	}

	public static Product create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight) {
        Product product = new Product(id, name, description, price, weight);

		product.record(new ProductCreatedDomainEvent(id.value(), name.value(), price.value()));

		return product;
	}

	public ProductId id() {
		return this.id;
	}

	public ProductName name() {
		return this.name;
	}

	public ProductDescription description() {
		return this.description;
	}

	public ProductPrice price() {
		return this.price;
	}

	public ProductWeight weight() {
		return this.weight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(this.id, product.id) && Objects.equals(this.name, product.name) && Objects.equals(this.description, product.description) && Objects.equals(this.price, product.price) && Objects.equals(this.weight, product.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.description, this.price, this.weight);
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + this.id +
				", name=" + this.name +
				", description=" + this.description +
				", price=" + this.price +
				", weight=" + this.weight +
				'}';
	}
}
