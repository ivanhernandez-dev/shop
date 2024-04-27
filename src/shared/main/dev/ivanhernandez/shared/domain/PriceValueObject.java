package dev.ivanhernandez.shared.domain;

import java.math.BigDecimal;

public abstract class PriceValueObject {
	private final BigDecimal value;

	public PriceValueObject(String value) {
		ensureValidPrice(new BigDecimal(value));
		this.value = new BigDecimal(value);
	}

	public String value() {
		return value.toString();
	}

	public boolean isLowerThan(PriceValueObject price) {
		return value.compareTo(price.value) < 0;
	}

	public boolean isGreaterThan(PriceValueObject price) {
		return value.compareTo(price.value) > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PriceValueObject)) {
			return false;
		}
		PriceValueObject that = (PriceValueObject) o;
		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public void ensureValidPrice(BigDecimal value) {
		if (value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("The price must be greater or equal than 0");
		}
	}
}
