package dev.ivanhernandez.inventory.stocks.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class StockAlreadyExist extends DomainError {
	public StockAlreadyExist(ShelfId shelfId, ProductId id) {
		super("stock_already_exist", String.format("The stock for the product with id <%s> in the shelf with id <%s> already exist", id.value(), shelfId.value()));
	}
}
