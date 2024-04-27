package tv.codely.inventory.products.application.create;

import tv.codely.inventory.products.domain.*;
import tv.codely.inventory.shared.domain.CategoryId;
import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.event.EventBus;

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
