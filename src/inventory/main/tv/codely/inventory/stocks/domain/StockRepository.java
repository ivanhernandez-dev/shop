package tv.codely.inventory.stocks.domain;

import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.inventory.shared.domain.ShelfId;

import java.util.Optional;

public interface StockRepository {
	void save(Stock stock);

	Optional<Stock> search(ProductId productId, ShelfId shelfId);

	void delete(ProductId productId, ShelfId shelfId);

	void update(Stock stock);
}
