package dev.ivanhernandez.catalog.products.application;

import dev.ivanhernandez.catalog.products.domain.Product;
import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.Objects;

public final class ProductResponse implements Response {
	private final String id;
	private final String name;
	private final String description;
	private final String price;
	private final Double weight;
	private final String color;
	private final String material;
	private final String categoryId;
	private final Boolean isThereStock;


	public ProductResponse(String id, String name, String description, String price, Double weight, String color, String material, String categoryId, Boolean isThereStock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.color = color;
		this.material = material;
		this.categoryId = categoryId;
		this.isThereStock = isThereStock;
	}

	public static ProductResponse fromAggregate(Product product, Boolean isThereStock) {
		return new ProductResponse(product.id().value(), product.name().value(), product.description().value(), product.price().value(), product.weight().value(), product.color().value(), product.material().value(), product.categoryId().value(), isThereStock);
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

	public String color() {
		return color;
	}

	public String material() {
		return material;
	}

	public String categoryId() {
		return categoryId;
	}

	public Boolean isThereStock() {
		return isThereStock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ProductResponse that = (ProductResponse) o;
		return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.description, that.description) && Objects.equals(this.price, that.price) && Objects.equals(this.weight, that.weight) && Objects.equals(this.color, that.color) && Objects.equals(this.material, that.material) && Objects.equals(this.categoryId, that.categoryId) && Objects.equals(this.isThereStock, that.isThereStock);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.description, this.price, this.weight, this.color, this.material, this.categoryId, this.isThereStock);
	}
}
