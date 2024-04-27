package dev.ivanhernandez.inventory.shelves;

import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.inventory.shelves.domain.ShelfRepository;
import dev.ivanhernandez.inventory.shelves.infrastructure.persistence.InMemoryShelfRepository;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ShelvesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryShelfRepository inMemoryRepository = new InMemoryShelfRepository();
	@Autowired
	protected ShelfRepository mySqlRepository;
	@Autowired
	protected WarehouseRepository warehouseRepository;
}
