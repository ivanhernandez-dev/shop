package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.StringValueObject;

public final class ProductName extends StringValueObject {
	public ProductName(String value) {
		super(value);
	}

	private ProductName() {
		super("");
	}
}
