package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.PriceValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductPrice {
	private final BigDecimal value;

	public ProductPrice(String value) {
		ensureValidPrice(value);
		this.value = new BigDecimal(value);
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
}
