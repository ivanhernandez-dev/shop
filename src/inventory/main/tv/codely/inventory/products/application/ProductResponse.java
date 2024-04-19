package tv.codely.inventory.products.application;

import tv.codely.inventory.products.domain.Product;

public final class ProductResponse {
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

	public static ProductResponse fromAggregate(Product product) {
		return new ProductResponse(product.id().value(), product.name().value(), product.description().value(), product.price().value(), product.weight().value());
	}
}
