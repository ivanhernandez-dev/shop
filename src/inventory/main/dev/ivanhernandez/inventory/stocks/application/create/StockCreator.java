package dev.ivanhernandez.inventory.stocks.application.create;

import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.application.find.ShelfFinder;
import dev.ivanhernandez.inventory.shelves.domain.Shelf;
import dev.ivanhernandez.inventory.stocks.application.find.StockFinder;
import dev.ivanhernandez.inventory.stocks.domain.Stock;
import dev.ivanhernandez.inventory.stocks.domain.StockAlreadyExist;
import dev.ivanhernandez.inventory.stocks.domain.StockQuantity;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class StockCreator {
	private final StockRepository repository;
	private final StockFinder finder;
	private final ShelfFinder shelfFinder;
	private final ProductFinder productFinder;

	public StockCreator(StockRepository repository, StockFinder finder, ShelfFinder shelfFinder, ProductFinder productFinder) {
		this.repository = repository;
		this.finder = finder;
		this.shelfFinder = shelfFinder;
		this.productFinder = productFinder;
	}

	public void create(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		try {
			finder.find(shelfId, productId);
			throw new StockAlreadyExist(shelfId, productId);
		} catch (Exception e) {
			shelfFinder.find(shelfId);
			productFinder.find(productId);

			Stock stock = Stock.create(shelfId, quantity, productId);
			repository.save(stock);
		}
	}
}
