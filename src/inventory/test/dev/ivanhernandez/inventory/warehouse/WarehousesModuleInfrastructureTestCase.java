package dev.ivanhernandez.inventory.warehouse;

import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseRepository;
import dev.ivanhernandez.inventory.warehouse.infrastructure.persistence.InMemoryWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class WarehousesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryWarehouseRepository inMemoryRepository = new InMemoryWarehouseRepository();
	@Autowired
	protected WarehouseRepository mySqlRepository;
}
