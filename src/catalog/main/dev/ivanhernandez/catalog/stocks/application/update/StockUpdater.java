package dev.ivanhernandez.catalog.stocks.application.update;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.catalog.stocks.application.create.StockCreator;
import dev.ivanhernandez.catalog.stocks.application.delete.StockDeleter;
import dev.ivanhernandez.catalog.stocks.application.find.StockFinder;
import dev.ivanhernandez.catalog.stocks.domain.Stock;
import dev.ivanhernandez.catalog.stocks.domain.StockNotExist;
import dev.ivanhernandez.catalog.stocks.domain.StockQuantity;
import dev.ivanhernandez.catalog.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class StockUpdater {
	private final StockRepository repository;
	private final StockFinder finder;
	private final StockDeleter deleter;
	private final StockCreator creator;

	public StockUpdater(StockRepository repository, StockFinder finder, StockDeleter deleter, StockCreator creator) {
		this.repository = repository;
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
			Stock stock = new Stock(shelfId, quantity, productId);
			repository.update(stock);
		} else if (quantity.value() != 0) {
			creator.create(shelfId, quantity, productId);
		}
	}
}
