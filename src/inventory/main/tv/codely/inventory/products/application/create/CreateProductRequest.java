package tv.codely.inventory.products.application.create;

import java.util.Objects;

public class CreateProductRequest {
	private String id;
	private String name;
	private String description;
	private String price;
	private Double weight;

	public CreateProductRequest(String id, String name, String description, String price, Double weight) {
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

	public String price() {
		return price;
	}

	public Double weight() {
		return weight;
	}

	public String description() {
		return description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CreateProductRequest that = (CreateProductRequest) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(weight, that.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, price, weight);
	}
}
