package dev.ivanhernandez.inventory.products.application;

import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.Objects;

public final class ProductResponse implements Response {
	private final String id;
	private final String name;
	private final String description;
	private final String price;
	private final Double weight;

	public ProductResponse(String id, String name, String description, String price, Double weight) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weight = weight;
	}

	public static ProductResponse fromAggregate(Product product) {
		return new ProductResponse(product.id().value(), product.name().value(), product.description().value(), product.price().value(), product.weight().value());
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public String price() {
		return price;
	}

	public Double weight() {
		return weight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ProductResponse that = (ProductResponse) o;
		return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.description, that.description) && Objects.equals(this.price, that.price) && Objects.equals(this.weight, that.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.description, this.price, this.weight);
	}
}
