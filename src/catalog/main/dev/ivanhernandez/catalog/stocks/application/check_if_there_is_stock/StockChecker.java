package dev.ivanhernandez.catalog.stocks.application.check_if_there_is_stock;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.stocks.application.IsThereStockResponse;
import dev.ivanhernandez.catalog.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class StockChecker {
	private final StockRepository repository;

	public StockChecker(StockRepository repository) {
		this.repository = repository;
	}

	public IsThereStockResponse check(ProductId productId) {
		return IsThereStockResponse.fromBoolean(repository.isThereStock(productId));
	}
}
