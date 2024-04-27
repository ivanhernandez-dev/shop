package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.shared.domain.MeasureValueObject;

public class ProductWeight extends MeasureValueObject {
	public ProductWeight(Double value) {
		super(value);
	}

	private ProductWeight() {
		super(null);
	}
}
