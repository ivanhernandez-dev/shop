package dev.ivanhernandez.catalog.stocks.application.create;

import dev.ivanhernandez.catalog.products.application.find.ProductFinder;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.catalog.stocks.application.find.StockFinder;
import dev.ivanhernandez.catalog.stocks.domain.Stock;
import dev.ivanhernandez.catalog.stocks.domain.StockAlreadyExist;
import dev.ivanhernandez.catalog.stocks.domain.StockQuantity;
import dev.ivanhernandez.catalog.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class StockCreator {
	private final StockRepository repository;
	private final StockFinder finder;
	private final ProductFinder productFinder;

	public StockCreator(StockRepository repository, StockFinder finder, ProductFinder productFinder) {
		this.repository = repository;
		this.finder = finder;
		this.productFinder = productFinder;
	}

	public void create(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		try {
			finder.find(shelfId, productId);
			throw new StockAlreadyExist(shelfId, productId);
		} catch (Exception e) {
			productFinder.find(productId);

			Stock stock = Stock.create(shelfId, quantity, productId);
			repository.save(stock);
		}
	}
}
