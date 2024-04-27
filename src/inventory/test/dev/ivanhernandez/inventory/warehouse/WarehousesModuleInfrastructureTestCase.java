package dev.ivanhernandez.inventory.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseRepository;
import dev.ivanhernandez.inventory.warehouse.infrastructure.persistence.InMemoryWarehouseRepository;

public abstract class WarehousesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryWarehouseRepository inMemoryRepository = new InMemoryWarehouseRepository();
	@Autowired
	protected WarehouseRepository mySqlRepository;
}
