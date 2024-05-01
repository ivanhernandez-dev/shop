package dev.ivanhernandez.inventory.products.application.delete;

import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class ProductDeleter {
	private final ProductRepository repository;
	private final ProductFinder finder;
	private final EventBus eventBus;


	public ProductDeleter(ProductRepository repository, EventBus eventBus, ProductFinder finder) {
		this.repository = repository;
		this.eventBus = eventBus;
		this.finder = finder;
	}

	public void delete(ProductId id) {
		Product product = Product.delete(id);

		finder.find(id);
		repository.delete(id);

		eventBus.publish(product.pullDomainEvents());
	}
}
