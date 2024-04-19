package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.StringValueObject;

public final class ProductDescription extends StringValueObject {
	public ProductDescription(String value) {
		super(value);
	}

	private ProductDescription() {
		super("");
	}
}
