package dev.ivanhernandez.inventory.products.application;

import dev.ivanhernandez.shared.domain.ListMother;

import java.util.List;

public final class ProductsReponseMother {
	public static ProductsResponse create(List<ProductResponse> productResponses) {
		return new ProductsResponse(productResponses);
	}

	public static ProductsResponse random() {
		return create(ListMother.random(ProductResponseMother::random));
	}
}
