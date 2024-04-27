package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class ProductCreator {
	private final ProductRepository repository;
	private final EventBus eventBus;

	public ProductCreator(ProductRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}

	public void create(CreateProductRequest request) {
		Product product = Product.create(new ProductId(request.id()), new ProductName(request.name()), new ProductDescription(request.description()), new ProductPrice(request.price()), new ProductWeight(request.weight()), new ProductColor(request.color()), new ProductMaterial(request.material()), new CategoryId(request.categoryId()));

		repository.save(product);

		eventBus.publish(product.pullDomainEvents());
	}
}
