package dev.ivanhernandez.inventory.products.application.find;

import dev.ivanhernandez.inventory.products.domain.ProductIdMother;

public final class FindProductQueryMother {
	public static FindProductQuery create(String id) {
		return new FindProductQuery(id);
	}

	public static FindProductQuery random() {
		return create(ProductIdMother.random().value());
	}
}
