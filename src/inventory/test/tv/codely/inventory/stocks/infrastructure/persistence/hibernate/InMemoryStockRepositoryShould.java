package tv.codely.inventory.stocks.infrastructure.persistence.hibernate;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.ProductIdMother;
import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.shelves.domain.ShelfIdMother;
import tv.codely.inventory.stocks.StocksModuleInfrastructureTestCase;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockMother;
import tv.codely.inventory.stocks.domain.StockQuantityMother;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryStockRepositoryShould extends StocksModuleInfrastructureTestCase {
	@Test
	void save_a_stock() {
		Stock stock = StockMother.random();

		assertEquals(Optional.empty(), inMemoryStockRepository.search(stock.productId(), stock.shelfId()));

		inMemoryStockRepository.save(stock);

		assertEquals(Optional.of(stock), inMemoryStockRepository.search(stock.productId(), stock.shelfId()));
	}

	@Test
	void return_an_existing_stock() {
		Stock stock = StockMother.random();

		inMemoryStockRepository.save(stock);

		assertEquals(Optional.of(stock), inMemoryStockRepository.search(stock.productId(), stock.shelfId()));
	}

	@Test
	void not_return_a_non_existing_stock() {
		ProductId productId = ProductIdMother.random();
		ShelfId shelfId = ShelfIdMother.random();

		assertFalse(inMemoryStockRepository.search(productId, shelfId).isPresent());
	}

	@Test
	void delete_an_existing_stock() {
		Stock stock = StockMother.random();

		inMemoryStockRepository.save(stock);
		inMemoryStockRepository.delete(stock.productId(), stock.shelfId());

		assertFalse(inMemoryStockRepository.search(stock.productId(), stock.shelfId()).isPresent());
	}

	@Test
	void update_a_stock() {
		Stock stock = StockMother.random();
		inMemoryStockRepository.save(stock);

		Stock updatedStock = StockMother.create(stock.shelfId(), StockQuantityMother.random(), stock.productId());
		inMemoryStockRepository.update(updatedStock);

		assertEquals(Optional.of(stock), inMemoryStockRepository.search(stock.productId(), stock.shelfId()));
	}
}
