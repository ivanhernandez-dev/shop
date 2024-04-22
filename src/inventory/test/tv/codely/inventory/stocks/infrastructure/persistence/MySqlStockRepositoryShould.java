package tv.codely.inventory.stocks.infrastructure.persistence;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.products.domain.ProductIdMother;
import tv.codely.inventory.shelves.domain.Shelf;
import tv.codely.inventory.shelves.domain.ShelfId;
import tv.codely.inventory.shelves.domain.ShelfIdMother;
import tv.codely.inventory.stocks.StockModuleInfrastructureTestCase;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockAmountMother;
import tv.codely.inventory.stocks.domain.StockMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlStockRepositoryShould extends StockModuleInfrastructureTestCase {
	@Test
	void save_a_stock() {
		Stock stock = StockMother.random();

		mySqlStockRepository.save(stock);
	}

	@Test
	void return_an_existing_stock() {
		Stock stock = StockMother.random();
		Product stockProduct = stock.product();
		Shelf stockShelf = stock.shelf();

		mySqlProductRepository.save(stockProduct);
		mySqlShelfRepository.save(stockShelf);

		mySqlStockRepository.save(stock);

		assertEquals(Optional.of(stock), mySqlStockRepository.search(stock.product().id(), stock.shelf().id()));
	}

	@Test
	void not_return_a_non_existing_stock() {
		ProductId productId = ProductIdMother.random();
		ShelfId shelfId = ShelfIdMother.random();

		assertFalse(mySqlStockRepository.search(productId, shelfId).isPresent());
	}

	@Test
	void delete_an_existing_stock() {
		Stock stock = StockMother.random();
		Product stockProduct = stock.product();
		Shelf stockShelf = stock.shelf();

		mySqlProductRepository.save(stockProduct);
		mySqlShelfRepository.save(stockShelf);

		mySqlStockRepository.save(stock);
		mySqlStockRepository.delete(stock.product().id(), stock.shelf().id());

		assertFalse(mySqlStockRepository.search(stock.product().id(), stock.shelf().id()).isPresent());
	}

	@Test
	void update_a_stock() {
		Stock stock = StockMother.random();
		Product stockProduct = stock.product();
		Shelf stockShelf = stock.shelf();

		mySqlProductRepository.save(stockProduct);
		mySqlShelfRepository.save(stockShelf);
		mySqlStockRepository.save(stock);

		Stock updatedStock = new Stock(stock.product(), stock.shelf(), StockAmountMother.random());
		mySqlStockRepository.update(updatedStock);

		assertEquals(Optional.of(updatedStock), mySqlStockRepository.search(stock.product().id(), stock.shelf().id()));
	}
}
