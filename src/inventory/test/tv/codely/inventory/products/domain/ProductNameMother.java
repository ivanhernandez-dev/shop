package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.WordMother;

import static org.junit.jupiter.api.Assertions.*;

public final class ProductNameMother {
	public static ProductName create(String value) {
		return new ProductName(value);
	}

	public static ProductName random() {
		return create(WordMother.random());
	}
}