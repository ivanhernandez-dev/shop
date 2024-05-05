package dev.ivanhernandez.inventory.stocks.application.delete;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.application.find.StockFinder;
import dev.ivanhernandez.inventory.stocks.domain.Stock;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class StockDeleter {
	private final StockRepository repository;
	private final EventBus eventBus;
	private final StockFinder finder;

	public StockDeleter(StockRepository repository, EventBus eventBus, StockFinder finder) {
		this.repository = repository;
		this.eventBus = eventBus;
		this.finder = finder;
	}

	public void delete(ShelfId shelfId, ProductId productId) {
		finder.find(shelfId, productId);
		Stock stock = Stock.delete(shelfId, productId);
		repository.delete(productId, shelfId);
		eventBus.publish(stock.pullDomainEvents());
	}
}
