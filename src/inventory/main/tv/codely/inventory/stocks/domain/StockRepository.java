package tv.codely.inventory.stocks.domain;

import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.shelves.domain.ShelfId;

import java.util.Optional;

public interface StockRepository {
	public void save(Stock stock);
	public Optional<Stock> search(ProductId productId, ShelfId shelfId);
	public void update(Stock stock);
	public void delete(ProductId productId, ShelfId shelfId);
}
