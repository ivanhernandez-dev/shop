package tv.codely.inventory.products.domain;

import tv.codely.inventory.products.application.create.CreateProductRequest;
import tv.codely.inventory.shared.domain.CategoryId;
import tv.codely.inventory.shared.domain.CategoryIdMother;
import tv.codely.inventory.shared.domain.ProductId;

public final class ProductMother {
	public static Product create(ProductId id, ProductName name, ProductPrice price, ProductDescription description, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		return Product.create(id, name, description, price, weight, color, material, categoryId);
	}

	public static Product random() {
		return create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), CategoryIdMother.random());
	}

	public static Product fromRequest(CreateProductRequest request) {
		return create(new ProductId(request.id()), new ProductName(request.name()), new ProductPrice(request.price()), new ProductDescription(request.description()), new ProductWeight(request.weight()), new ProductColor(request.color()), new ProductMaterial(request.material()), CategoryIdMother.create(request.categoryId()));
	}
}
