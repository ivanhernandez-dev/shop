package tv.codely.inventory.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.warehouse.domain.WarehouseRepository;
import tv.codely.inventory.warehouse.infrastructure.persistence.InMemoryWarehouseRepository;

public abstract class WarehousesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryWarehouseRepository inMemoryRepository = new InMemoryWarehouseRepository();
	@Autowired
	protected WarehouseRepository mySqlRepository;
}
