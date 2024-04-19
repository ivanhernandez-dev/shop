package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.MeasureValueObject;

public class ProductWeight extends MeasureValueObject {
	public ProductWeight(Double value) {
		super(value);
	}

	private ProductWeight() {
		super(null);
	}
}
