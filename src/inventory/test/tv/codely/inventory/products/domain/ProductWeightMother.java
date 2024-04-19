package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.MeasureMother;

public class ProductWeightMother {
	public static ProductWeight create(Double value) {
		return new ProductWeight(value);
	}

	public static ProductWeight random() {
		return create(MeasureMother.random());
	}
}
