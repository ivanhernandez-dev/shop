package tv.codely.inventory.products.application.create;

import java.math.BigDecimal;

public class CreateProductRequest {
	private String id;
	private String name;
	private String price;

	public CreateProductRequest(String id, String name, String price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CreateProductRequest request = (CreateProductRequest) o;
		return id.equals(request.id) && name.equals(request.name) && price.equals(request.price);
	}

	@Override
	public int hashCode() {
		return id.hashCode() + name.hashCode() + price.hashCode();
	}
}
