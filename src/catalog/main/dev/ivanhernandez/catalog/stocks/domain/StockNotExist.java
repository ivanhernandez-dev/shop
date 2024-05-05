package dev.ivanhernandez.catalog.stocks.domain;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class StockNotExist extends DomainError {
	public StockNotExist(ShelfId shelfId, ProductId productId) {
		super("stock_not_exist", String.format("The stock for the shelf <%s> and the product <%s> does not exist", shelfId.value(), productId.value()));
	}
}
