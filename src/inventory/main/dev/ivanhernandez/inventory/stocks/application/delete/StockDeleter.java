package dev.ivanhernandez.inventory.stocks.application.delete;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.application.find.StockFinder;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class StockDeleter {
	private final StockRepository repository;
	private final StockFinder finder;

	public StockDeleter(StockRepository repository, StockFinder finder) {
		this.repository = repository;
		this.finder = finder;
	}

	public void delete(ShelfId shelfId, ProductId productId) {
		finder.find(shelfId, productId);
		repository.delete(productId, shelfId);
	}
}
