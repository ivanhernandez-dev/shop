package tv.codely.inventory.stocks.infrastructure.persistence;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import tv.codely.inventory.category.domain.Category;
import tv.codely.inventory.category.domain.CategoryMother;
import tv.codely.inventory.products.domain.*;
import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.shelves.domain.*;
import tv.codely.inventory.stocks.StocksModuleInfrastructureTestCase;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockMother;
import tv.codely.inventory.stocks.domain.StockQuantityMother;
import tv.codely.inventory.warehouse.domain.Warehouse;
import tv.codely.inventory.warehouse.domain.WarehouseMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MysqlStockRepositoryShould extends StocksModuleInfrastructureTestCase {

	private Stock stock;

	private Stock createRandomStock() {
		Category category = CategoryMother.random();
		this.categoryRepository.save(category);

		Product product = ProductMother.create(
			ProductIdMother.random(),
			ProductNameMother.random(),
			ProductPriceMother.random(),
			ProductDescriptionMother.random(),
			ProductWeightMother.random(),
			ProductColorMother.random(),
			ProductMaterialMother.random(),
			category.id()
		);
		this.productRepository.save(product);

		Warehouse warehouse = WarehouseMother.random();
		this.warehouseRepository.save(warehouse);

		Shelf shelf = ShelfMother.create(
			ShelfIdMother.random(),
			ShelfLengthMother.random(),
			ShelfWidthMother.random(),
			ShelfMaxWeightMother.random(),
			warehouse.id()
		);
		this.shelfRepository.save(shelf);

		return StockMother.create(
			shelf.id(),
			StockQuantityMother.random(),
			product.id()
		);
	}

	@BeforeAll
	void setUp() {
		this.stock = this.createRandomStock();
	}

	@Test
	void save_a_stock() {
		assertEquals(Optional.empty(), this.mySqlstockRepository.search(stock.productId(), stock.shelfId()));

		this.mySqlstockRepository.save(stock);

		assertEquals(Optional.of(stock), this.mySqlstockRepository.search(stock.productId(), stock.shelfId()));
	}

	@Test
	void return_an_existing_stock() {
		this.mySqlstockRepository.save(stock);
		assertEquals(Optional.of(stock), this.mySqlstockRepository.search(stock.productId(), stock.shelfId()));
	}

	@Test
	void not_return_a_non_existing_stock() {
		ProductId productId = ProductIdMother.random();
		ShelfId shelfId = ShelfIdMother.random();

		assertEquals(Optional.empty(), this.mySqlstockRepository.search(productId, shelfId));
	}

	@Test
	void delete_an_existing_stock() {
		this.mySqlstockRepository.save(stock);

		this.mySqlstockRepository.delete(stock.productId(), stock.shelfId());

		assertEquals(Optional.empty(), this.mySqlstockRepository.search(stock.productId(), stock.shelfId()));
	}

	@Test
	void update_a_stock() {
		this.mySqlstockRepository.save(stock);

		Stock updatedStock = StockMother.create(
			stock.shelfId(),
			StockQuantityMother.random(),
			stock.productId()
		);

		this.mySqlstockRepository.update(updatedStock);

		assertEquals(Optional.of(updatedStock), this.mySqlstockRepository.search(updatedStock.productId(), updatedStock.shelfId()));
	}
}
