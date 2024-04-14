package tv.codely.inventory.products.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Product {
	private String id;
	private String name;
	private BigDecimal price;

	public Product(String id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public static Product create(String id, String name, BigDecimal price) {
		return new Product(id, name, price);
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public BigDecimal price() {
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
