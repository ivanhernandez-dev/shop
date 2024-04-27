package tv.codely.inventory.shared.domain;

import tv.codely.shared.domain.IdentifierValueObject;

public final class ProductId extends IdentifierValueObject {
	public ProductId(String value) {
		super(value);
	}

	private ProductId() {
	}

	@Override
	public String toString() {
		return value;
	}
}
