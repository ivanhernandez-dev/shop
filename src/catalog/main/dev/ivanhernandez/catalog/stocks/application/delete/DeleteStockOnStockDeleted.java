package dev.ivanhernandez.catalog.stocks.application.delete;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.stock.StockDeletedDomainEvent;

@Component
@DomainEventSubscriber({StockDeletedDomainEvent.class})
public final class DeleteStockOnStockDeleted {
	private final StockDeleter deleter;

	public DeleteStockOnStockDeleted(StockDeleter deleter) {
		this.deleter = deleter;
	}

	public void on(StockDeletedDomainEvent event) {
		deleter.delete(new ShelfId(event.shelfId()), new ProductId(event.productId()));
	}
}
