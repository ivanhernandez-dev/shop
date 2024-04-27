package dev.ivanhernandez.inventory.category;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.inventory.category.infrastructure.persistence.InMemoryCategoryRepository;

public abstract class CategoriesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryCategoryRepository inMemoryRepository = new InMemoryCategoryRepository();
	@Autowired
	protected CategoryRepository mySqlRepository;
}
