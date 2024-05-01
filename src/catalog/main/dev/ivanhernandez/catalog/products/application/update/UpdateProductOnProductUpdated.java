
package dev.ivanhernandez.catalog.products.application.update;

import dev.ivanhernandez.catalog.products.application.create.ProductCreator;
import dev.ivanhernandez.catalog.products.domain.*;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.product.ProductCreatedDomainEvent;
import dev.ivanhernandez.shared.domain.product.ProductUpdatedDomainEvent;
import org.springframework.context.event.EventListener;

@Component
@DomainEventSubscriber({ProductUpdatedDomainEvent.class})
public final class UpdateProductOnProductUpdated {
	private final ProductUpdater updater;

	public UpdateProductOnProductUpdated(ProductUpdater updater) {
		this.updater = updater;
	}

	@EventListener
	public void on(ProductUpdatedDomainEvent event) {
		updater.update(
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
