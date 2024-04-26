package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.StringValueObject;

public final class ProductColor {
	private final String value;

	public static final String COLOR_RED = "red";
	public static final String COLOR_BLUE = "blue";
	public static final String COLOR_YELLOW = "yellow";
	public static final String COLOR_GREEN = "green";
	public static final String COLOR_BLACK = "black";
	public static final String COLOR_WHITE = "white";
	public static final String COLOR_ORANGE = "orange";
	public static final String COLOR_PURPLE = "purple";
	public static final String COLOR_PINK = "pink";
	public static final String COLOR_GREY = "grey";
	public static final String COLOR_BROWN = "brown";
	public static final String COLOR_GOLD = "gold";
	public static final String COLOR_SILVER = "silver";

	private static final String[] VALID_COLORS = {
		COLOR_RED,
		COLOR_BLUE,
		COLOR_YELLOW,
		COLOR_GREEN,
		COLOR_BLACK,
		COLOR_WHITE,
		COLOR_ORANGE,
		COLOR_PURPLE,
		COLOR_PINK,
		COLOR_GREY,
		COLOR_BROWN,
		COLOR_GOLD,
		COLOR_SILVER
	};

	public ProductColor(String value) {
		String color = value.toLowerCase().trim();
		ensureValidColor(color);
		this.value = color;
	}

	private ProductColor() {
		this.value = null;
	}

	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProductColor that = (ProductColor) o;

		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	private void ensureValidColor(String value) {
		for (String color : VALID_COLORS) {
			if (color.equals(value)) {
				return;
			}
		}

		throw new IllegalArgumentException("The color must be one of: " + String.join(", ", VALID_COLORS));
	}
}
