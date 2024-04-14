package tv.codely.inventory.products;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.inventory.products.infrastructure.persistence.InMemoryProductRepository;

public abstract class ProductsModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryProductRepository inMemoryRepository = new InMemoryProductRepository();
	@Autowired
	protected ProductRepository mySqlRepository;
}
