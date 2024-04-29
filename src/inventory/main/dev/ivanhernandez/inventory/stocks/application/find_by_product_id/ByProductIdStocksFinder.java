package dev.ivanhernandez.inventory.stocks.application.find_by_product_id;

import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.stocks.application.StockResponse;
import dev.ivanhernandez.inventory.stocks.application.StocksResponse;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class ByProductIdStocksFinder {
	private final StockRepository repository;
	private final ProductFinder productFinder;

	public ByProductIdStocksFinder(StockRepository repository, ProductFinder productFinder) {
		this.repository = repository;
		this.productFinder = productFinder;
	}

	public StocksResponse find(ProductId productId) {
		productFinder.find(productId);
		return new StocksResponse(repository.searchByProductId(productId).stream().map(StockResponse::fromAggregate).toList());
	}
}
