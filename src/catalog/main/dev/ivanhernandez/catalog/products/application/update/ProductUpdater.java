package dev.ivanhernandez.catalog.products.application.update;

import dev.ivanhernandez.catalog.category.application.find.CategoryFinder;
import dev.ivanhernandez.catalog.products.application.ProductResponse;
import dev.ivanhernandez.catalog.products.application.find.ProductFinder;
import dev.ivanhernandez.catalog.products.domain.*;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class ProductUpdater {
	private final ProductRepository repository;
	private final EventBus eventBus;
	private final ProductFinder finder;
	private final CategoryFinder categoryFinder;

	public ProductUpdater(ProductRepository repository, EventBus eventBus, ProductFinder finder , CategoryFinder categoryFinder) {
		this.repository = repository;
		this.eventBus = eventBus;
		this.finder = finder;
		this.categoryFinder = categoryFinder;
	}

	public void update(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		ProductResponse oldProduct = finder.find(id);

		if (!oldProduct.categoryId().equals(categoryId.value())) {
			categoryFinder.find(categoryId);
		}

		Product product = Product.update(id, name, description, price, weight, color, material, categoryId);

		repository.update(product);
	}
}
