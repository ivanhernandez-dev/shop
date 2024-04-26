package tv.codely.inventory.products.application.create;

import java.util.Objects;

public class CreateProductRequest {
	private String id;
	private String name;
	private String description;
	private String price;
	private Double weight;
	private String color;
	private String material;

	public CreateProductRequest(String id, String name, String description, String price, Double weight, String color, String material) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.color = color;
		this.material = material;
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

	public String color() {
		return color;
	}

	public String material() {
		return material;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		CreateProductRequest that = (CreateProductRequest) o;
		return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.description, that.description) && Objects.equals(this.price, that.price) && Objects.equals(this.weight, that.weight) && Objects.equals(this.color, that.color) && Objects.equals(this.material, that.material);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.description, this.price, this.weight, this.color, this.material);
	}
}
