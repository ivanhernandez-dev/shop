package tv.codely.inventory.stocks.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.products.domain.ProductIdMother;
import tv.codely.inventory.shelves.domain.ShelfId;
import tv.codely.inventory.shelves.domain.ShelfIdMother;
import tv.codely.inventory.stocks.StockModuleInfrastructureTestCase;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockAmountMother;
import tv.codely.inventory.stocks.domain.StockMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStockRepositoryShould extends StockModuleInfrastructureTestCase {
	@Test
	void save_a_stock() {
		Stock stock = StockMother.random();

		inMemoryRepository.save(stock);
	}

	@Test
	void return_an_existing_stock() {
		Stock stock = StockMother.random();

		inMemoryRepository.save(stock);

		assertEquals(Optional.of(stock), inMemoryRepository.search(stock.product().id(), stock.shelf().id()));
	}

	@Test
	void not_return_a_non_existing_stock() {
		ProductId productId = ProductIdMother.random();
		ShelfId shelfId = ShelfIdMother.random();

		assertFalse(inMemoryRepository.search(productId, shelfId).isPresent());
	}

	@Test
	void delete_an_existing_stock() {
		Stock stock = StockMother.random();

		inMemoryRepository.save(stock);
		inMemoryRepository.delete(stock.product().id(), stock.shelf().id());

		assertFalse(inMemoryRepository.search(stock.product().id(), stock.shelf().id()).isPresent());
	}

	@Test
	void update_a_stock() {
		Stock stock = StockMother.random();
		inMemoryRepository.save(stock);

		Stock updatedStock = new Stock(stock.product(), stock.shelf(), StockAmountMother.random());
		inMemoryRepository.update(updatedStock);

		assertEquals(Optional.of(updatedStock), inMemoryRepository.search(stock.product().id(), stock.shelf().id()));
	}
}
