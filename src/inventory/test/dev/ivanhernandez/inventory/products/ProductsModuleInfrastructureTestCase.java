package dev.ivanhernandez.inventory.products;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.inventory.products.infrastructure.persistence.InMemoryProductRepository;

public abstract class ProductsModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryProductRepository inMemoryRepository = new InMemoryProductRepository();
	@Autowired
	protected ProductRepository mySqlRepository;
	@Autowired
	protected CategoryRepository categoryRepository;
}
