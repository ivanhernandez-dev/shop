package tv.codely.inventory.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.inventory.shelves.domain.ShelfRepository;
import tv.codely.inventory.stocks.domain.StockRepository;
import tv.codely.inventory.stocks.infrastructure.persistence.InMemoryStockRepository;

public abstract class StockModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryStockRepository inMemoryRepository = new InMemoryStockRepository();
	@Autowired
	protected StockRepository mySqlStockRepository;
	@Autowired
	protected ProductRepository mySqlProductRepository;
	@Autowired
	protected ShelfRepository mySqlShelfRepository;
}
