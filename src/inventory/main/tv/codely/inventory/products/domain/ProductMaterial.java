package tv.codely.inventory.products.domain;

public final class ProductMaterial {
	private final String value;

	public static final String MATERIAL_WOOD = "wood";
	public static final String MATERIAL_METAL = "metal";
	public static final String MATERIAL_PLASTIC = "plastic";
	public static final String MATERIAL_GLASS = "glass";
	public static final String MATERIAL_CERAMIC = "ceramic";
	public static final String MATERIAL_FABRIC = "fabric";
	public static final String MATERIAL_LEATHER = "leather";
	public static final String MATERIAL_STONE = "stone";
	public static final String MATERIAL_PAPER = "paper";
	public static final String MATERIAL_RUBBER = "rubber";
	public static final String MATERIAL_LATEX = "latex";
	public static final String MATERIAL_SILICONE = "silicone";

	private static final String[] VALID_MATERIALS = {
		MATERIAL_WOOD,
		MATERIAL_METAL,
		MATERIAL_PLASTIC,
		MATERIAL_GLASS,
		MATERIAL_CERAMIC,
		MATERIAL_FABRIC,
		MATERIAL_LEATHER,
		MATERIAL_STONE,
		MATERIAL_PAPER,
		MATERIAL_RUBBER,
		MATERIAL_LATEX,
		MATERIAL_SILICONE
	};

	public ProductMaterial(String value) {
		String material = value.toLowerCase().trim();
		ensureValidMaterial(material);
		this.value = material;
	}

	private ProductMaterial() {
		this.value = null;
	}

	public String value() {
		return value;
	}

	public void ensureValidMaterial(String value) {
		for (String material : VALID_MATERIALS) {
			if (material.equals(value)) {
				return;
			}
		}

		throw new IllegalArgumentException("The material must be one of: " + String.join(", ", VALID_MATERIALS));
	}
}
