package tv.codely.inventory.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.inventory.backend.InventoryBackendApplication;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

public abstract class ProductsModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	@Autowired
	protected ProductRepository repository;
}
