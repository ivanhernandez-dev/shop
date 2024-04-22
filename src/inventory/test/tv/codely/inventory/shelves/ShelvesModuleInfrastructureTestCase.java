package tv.codely.inventory.shelves;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.shelves.domain.ShelfRepository;
import tv.codely.inventory.shelves.infrastructure.persistence.InMemoryShelfRepository;

public abstract class ShelvesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryShelfRepository inMemoryRepository = new InMemoryShelfRepository();
	@Autowired
	protected ShelfRepository mySqlRepository;
}