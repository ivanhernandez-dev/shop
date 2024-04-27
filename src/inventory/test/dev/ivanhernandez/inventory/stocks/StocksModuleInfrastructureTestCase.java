package dev.ivanhernandez.inventory.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.inventory.shelves.domain.ShelfRepository;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.inventory.stocks.infrastructure.persistence.InMemoryStockRepository;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseRepository;

public class StocksModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryStockRepository inMemoryStockRepository = new InMemoryStockRepository();
	@Autowired
	protected StockRepository mySqlstockRepository;
	@Autowired
	protected ShelfRepository shelfRepository;
	@Autowired
	protected WarehouseRepository warehouseRepository;
	@Autowired
	protected ProductRepository productRepository;
	@Autowired
	protected CategoryRepository categoryRepository;
}
