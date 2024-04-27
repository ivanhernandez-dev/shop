package dev.ivanhernandez.inventory.stocks.domain;

import dev.ivanhernandez.inventory.products.domain.ProductIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shared.domain.WarehouseId;
import dev.ivanhernandez.inventory.shelves.domain.ShelfIdMother;

public final class StockMother {
	public static Stock create(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		return new Stock(shelfId, quantity, productId);
	}

	public static Stock random() {
		return create(ShelfIdMother.random(), StockQuantityMother.random(), ProductIdMother.random());
	}
}
