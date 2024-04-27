package tv.codely.inventory.stocks.domain;

import tv.codely.inventory.products.domain.ProductIdMother;
import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.inventory.shelves.domain.ShelfIdMother;

public final class StockMother {
	public static Stock create(ShelfId shelfId, StockQuantity quantity, ProductId productId) {
		return new Stock(shelfId, quantity, productId);
	}

	public static Stock random() {
		return create(ShelfIdMother.random(), StockQuantityMother.random(), ProductIdMother.random());
	}
}
