package tv.codely.inventory.products.domain;

import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.shared.domain.UuidMother;

public final class ProductIdMother {
	public static ProductId create(String value) {
		return new ProductId(value);
	}

	public static ProductId random() {
		return create(UuidMother.random());
	}
}
