package dev.ivanhernandez.catalog.products.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class ProductPrice {
	private final BigDecimal value;

	public ProductPrice(String value) {
		ensureValidPrice(value);
		this.value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private ProductPrice() {
		this.value = null;
	}

	public String value() {
		return value.toString();
	}

	public void ensureValidPrice(String value) {
		if (new BigDecimal(value).compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("The price must be greater or equal than 0");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductPrice that = (ProductPrice) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	public int compareTo(ProductPrice price) {
		return value.compareTo(price.value);
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
