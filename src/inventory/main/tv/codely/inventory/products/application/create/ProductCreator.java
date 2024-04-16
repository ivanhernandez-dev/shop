package tv.codely.inventory.products.application.create;

import tv.codely.inventory.products.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

import java.math.BigDecimal;

@Service
public final class ProductCreator {
	private final ProductRepository repository;
	private final EventBus eventBus;

	public ProductCreator(ProductRepository repository, EventBus eventBus) {
	 	this.repository = repository;
		this.eventBus = eventBus;
	}

	public void create(CreateProductRequest request) {
		Product product = Product.create(new ProductId(request.id()), new ProductName(request.name()), new ProductPrice(request.price()));

		repository.save(product);

		eventBus.publish(product.pullDomainEvents());
	}
}
