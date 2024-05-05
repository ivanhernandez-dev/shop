package dev.ivanhernandez.catalog.stocks.infrastructure.persistence;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.shared.domain.ShelfId;
import dev.ivanhernandez.catalog.stocks.domain.Stock;
import dev.ivanhernandez.catalog.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;

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

	@Override
	public List<Stock> searchByProductId(ProductId productId) {
		return this.stocks.values().stream().filter(stock -> stock.productId().equals(productId)).toList();
	}

	@Override
	public List<Stock> searchByShelfId(ShelfId shelfId) {
		return this.stocks.values().stream().filter(stock -> stock.shelfId().equals(shelfId)).toList();
	}

	@Override
	public boolean isThereStock(ProductId productId) {
		return this.stocks.values().stream().anyMatch(stock -> stock.productId().equals(productId));
	}
}
