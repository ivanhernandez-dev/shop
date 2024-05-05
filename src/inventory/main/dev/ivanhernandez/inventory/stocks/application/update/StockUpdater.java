package dev.ivanhernandez.inventory.stocks.application.update;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.application.create.StockCreator;
import dev.ivanhernandez.inventory.stocks.application.delete.StockDeleter;
import dev.ivanhernandez.inventory.stocks.application.find.StockFinder;
import dev.ivanhernandez.inventory.stocks.domain.Stock;
import dev.ivanhernandez.inventory.stocks.domain.StockNotExist;
import dev.ivanhernandez.inventory.stocks.domain.StockQuantity;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class StockUpdater {
	private final StockRepository repository;
	private final EventBus eventBus;
	private final StockFinder finder;
	private final StockDeleter deleter;
	private final StockCreator creator;

	public StockUpdater(StockRepository repository, EventBus eventBus, StockFinder finder, StockDeleter deleter, StockCreator creator) {
		this.repository = repository;
		this.eventBus = eventBus;
		this.finder = finder;
		this.deleter = deleter;
		this.creator = creator;
	}

	public void update(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		boolean stockExists = true;

		try {
			finder.find(shelfId, productId);
		} catch (StockNotExist e) {
			stockExists = false;
		}

		if (stockExists && quantity.value() == 0) {
			deleter.delete(shelfId, productId);
		} else if (stockExists) {
			Stock stock = Stock.update(shelfId, quantity, productId);
			repository.update(stock);
			eventBus.publish(stock.pullDomainEvents());
		} else if (quantity.value() != 0) {
			creator.create(shelfId, quantity, productId);
		}
	}
}
