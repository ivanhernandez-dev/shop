package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.shared.domain.MeasureMother;

public class ProductWeightMother {
	public static ProductWeight create(Double value) {
		return new ProductWeight(value);
	}

	public static ProductWeight random() {
		return create(MeasureMother.random());
	}
}
