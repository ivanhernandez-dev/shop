package dev.ivanhernandez.catalog.products.application.create;

import dev.ivanhernandez.catalog.products.domain.*;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.product.ProductCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@Component
@DomainEventSubscriber({ProductCreatedDomainEvent.class})
public final class CreateProductOnProductCreated {
	private final ProductCreator creator;

	public CreateProductOnProductCreated(ProductCreator creator) {
		this.creator = creator;
	}

	@EventListener
	public void on(ProductCreatedDomainEvent event) {
		creator.create(
			new ProductId(event.aggregateId()),
			new ProductName(event.name()),
			new ProductDescription(event.description()),
			new ProductPrice(event.price()),
			new ProductWeight(event.weight()),
			new ProductColor(event.color()),
			new ProductMaterial(event.material()),
			new CategoryId(event.categoryId())
		);
	}
}
