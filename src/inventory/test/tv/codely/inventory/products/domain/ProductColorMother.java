package tv.codely.inventory.products.domain;

public final class ProductColorMother {
	private static final String[] COLORS = {"red", "blue", "green", "yellow", "black", "white", "purple", "orange", "pink", "brown"};

	public static ProductColor create(String value) {
		return new ProductColor(value);
	}

	public static ProductColor random() {
		return create(COLORS[(int) (Math.random() * COLORS.length)]);
	}
}
