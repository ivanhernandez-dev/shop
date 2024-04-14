package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.IdentifierValueObject;

public class ProductId extends IdentifierValueObject {
	public ProductId(String value) {
		super(value);
	}

	private ProductId() {
	}
}
