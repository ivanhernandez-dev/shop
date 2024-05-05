package dev.ivanhernandez.catalog.stocks.application.update;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.catalog.stocks.domain.StockQuantity;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.stock.StockUpdatedDomainEvent;

@Component
@DomainEventSubscriber({StockUpdatedDomainEvent.class})
public final class UpdateStockOnStockDeleted {
	private final StockUpdater updater;

	public UpdateStockOnStockDeleted(StockUpdater updater) {
		this.updater = updater;
	}

	public void on(StockUpdatedDomainEvent event) {
		updater.update(new ShelfId(event.shelfId()), new StockQuantity(event.quantity()), new ProductId(event.productId()));
	}
}
