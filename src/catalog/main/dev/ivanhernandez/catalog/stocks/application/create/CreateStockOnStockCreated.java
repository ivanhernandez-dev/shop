package dev.ivanhernandez.catalog.stocks.application.create;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.catalog.stocks.domain.StockQuantity;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.stock.StockCreatedDomainEvent;

@Component
@DomainEventSubscriber({StockCreatedDomainEvent.class})
public final class CreateStockOnStockCreated {
	private final StockCreator creator;

	public CreateStockOnStockCreated(StockCreator creator) {
		this.creator = creator;
	}

	public void on(StockCreatedDomainEvent event) {
		creator.create(new ShelfId(event.shelfId()), new StockQuantity(event.quantity()), new ProductId(event.productId()));
	}
}
