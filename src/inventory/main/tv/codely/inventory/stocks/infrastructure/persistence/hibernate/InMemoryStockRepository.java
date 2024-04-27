package tv.codely.inventory.stocks.infrastructure.persistence.hibernate;

import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockRepository;
import tv.codely.shared.domain.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryStockRepository implements StockRepository {
	private final Map<List<String>, Stock> stocks = new HashMap<>();

	@Override
	public void save(Stock stock) {
		this.stocks.put(List.of(stock.productId().value(), stock.shelfId().value()), stock);
	}

	@Override
	public Optional<Stock> search(ProductId productId, ShelfId shelfId) {
		return Optional.ofNullable(this.stocks.get(List.of(productId.value(), shelfId.value())));
	}

	@Override
	public void delete(ProductId productId, ShelfId shelfId) {
		this.stocks.remove(List.of(productId.value(), shelfId.value()));
	}

	@Override
	public void update(Stock stock) {
		this.stocks.put(List.of(stock.productId().value(), stock.shelfId().value()), stock);
	}
}
