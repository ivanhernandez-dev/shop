package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.category.application.find.CategoryFinder;
import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class ProductCreator {
	private final ProductRepository repository;
	private final EventBus eventBus;
	private final ProductFinder finder;
	private final CategoryFinder categoryFinder;

	public ProductCreator(ProductRepository repository, EventBus eventBus, ProductFinder finder , CategoryFinder categoryFinder) {
		this.repository = repository;
		this.eventBus = eventBus;
		this.finder = finder;
		this.categoryFinder = categoryFinder;
	}

	public void create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		try {
			finder.find(id);
			throw new ProductAlreadyExist(id);
		} catch (ProductNotExist e) {
			categoryFinder.find(categoryId);

			Product product = Product.create(id, name, description, price, weight, color, material, categoryId);

			repository.save(product);
			eventBus.publish(product.pullDomainEvents());
		}
	}
}
