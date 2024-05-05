package dev.ivanhernandez.catalog.stocks.application.check_if_there_is_stock;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.stocks.application.IsThereStockResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public class CheckIfThereIsStockQueryHandler implements QueryHandler<CheckIfThereIsStockQuery, IsThereStockResponse> {
	private final StockChecker checker;

	public CheckIfThereIsStockQueryHandler(StockChecker checker) {
		this.checker = checker;
	}

	@Override
	public IsThereStockResponse handle(CheckIfThereIsStockQuery query) {
		return checker.check(new ProductId(query.productId()));
	}
}
