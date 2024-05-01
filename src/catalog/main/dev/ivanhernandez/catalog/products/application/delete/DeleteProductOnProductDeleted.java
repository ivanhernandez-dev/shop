package dev.ivanhernandez.catalog.products.application.delete;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.product.ProductDeletedDomainEvent;
import org.springframework.context.event.EventListener;

@Component
@DomainEventSubscriber({ProductDeletedDomainEvent.class})
public final class DeleteProductOnProductDeleted {
	private final ProductDeleter deleter;

	public DeleteProductOnProductDeleted(ProductDeleter deleter) {
		this.deleter = deleter;
	}

	@EventListener
	public void on(ProductDeletedDomainEvent event) {
		deleter.delete(new ProductId(event.aggregateId()));
	}
}
