package tv.codely.inventory.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.category.domain.CategoryRepository;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.inventory.shelves.domain.ShelfRepository;
import tv.codely.inventory.stocks.domain.StockRepository;
import tv.codely.inventory.stocks.infrastructure.persistence.InMemoryStockRepository;
import tv.codely.inventory.warehouse.domain.WarehouseRepository;

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
