package dev.ivanhernandez.catalog.stocks.domain;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;

import java.util.List;
import java.util.Optional;

public interface StockRepository {
	void save(Stock stock);

	Optional<Stock> search(ProductId productId, ShelfId shelfId);

	void delete(ProductId productId, ShelfId shelfId);

	void update(Stock stock);

	List<Stock> searchByProductId(ProductId productId);

	List<Stock> searchByShelfId(ShelfId shelfId);

	boolean isThereStock(ProductId productId);
}
