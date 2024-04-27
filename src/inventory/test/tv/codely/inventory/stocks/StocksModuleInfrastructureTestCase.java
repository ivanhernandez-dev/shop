package tv.codely.inventory.stocks;

import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.stocks.infrastructure.persistence.hibernate.InMemoryStockRepository;

public class StocksModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryStockRepository inMemoryStockRepository = new InMemoryStockRepository();
}
