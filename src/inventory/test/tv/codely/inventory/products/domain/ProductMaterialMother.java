package tv.codely.inventory.products.domain;

public final class ProductMaterialMother {
	private static final String[] MATERIALS = {"wood", "metal", "plastic", "glass", "ceramic", "fabric", "leather", "paper", "rubber", "stone"};

	public static ProductMaterial create(String value) {
		return new ProductMaterial(value);
	}

	public static ProductMaterial random() {
		return create(MATERIALS[(int) (Math.random() * MATERIALS.length)]);
	}
}
