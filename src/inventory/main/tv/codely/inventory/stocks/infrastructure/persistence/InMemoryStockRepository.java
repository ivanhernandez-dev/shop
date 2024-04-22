package tv.codely.inventory.stocks.infrastructure.persistence;

import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.shelves.domain.ShelfId;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockRepository;
import tv.codely.shared.domain.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryStockRepository implements StockRepository {
	private final HashMap<List<String>, Stock> stocks = new HashMap<>();

	@Override
	public void save(Stock stock) {
		this.stocks.put(List.of(stock.product().id().value(), stock.shelf().id().value()), stock);
	}

	@Override
	public Optional<Stock> search(ProductId productId, ShelfId shelfId) {
		return Optional.ofNullable(this.stocks.get(List.of(productId.value(), shelfId.value())));
	}

	@Override
	public void update(Stock stock) {
		if (this.stocks.containsKey(List.of(stock.product().id().value(), stock.shelf().id().value()))) {
			this.stocks.put(List.of(stock.product().id().value(), stock.shelf().id().value()), stock);
		}
	}

	@Override
	public void delete(ProductId productId, ShelfId shelfId) {
		this.stocks.remove(List.of(productId.value(), shelfId.value()));
	}
}
