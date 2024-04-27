package dev.ivanhernandez.inventory.stocks.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;

import java.util.Optional;

public interface StockRepository {
	void save(Stock stock);

	Optional<Stock> search(ProductId productId, ShelfId shelfId);

	void delete(ProductId productId, ShelfId shelfId);

	void update(Stock stock);
}
