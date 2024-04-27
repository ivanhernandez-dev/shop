package dev.ivanhernandez.inventory.stocks.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import dev.ivanhernandez.inventory.products.domain.ProductIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.domain.ShelfIdMother;
import dev.ivanhernandez.inventory.stocks.StocksModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.stocks.domain.Stock;
import dev.ivanhernandez.inventory.stocks.domain.StockMother;
import dev.ivanhernandez.inventory.stocks.domain.StockQuantityMother;

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

		assertEquals(Optional.of(updatedStock), inMemoryStockRepository.search(stock.productId(), stock.shelfId()));
	}
}
