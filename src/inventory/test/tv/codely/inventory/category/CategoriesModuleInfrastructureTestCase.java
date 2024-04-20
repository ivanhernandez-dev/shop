package tv.codely.inventory.category;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.inventory.InventoryContextInfrastructureTestCase;
import tv.codely.inventory.category.domain.CategoryRepository;
import tv.codely.inventory.category.infrastructure.persistence.InMemoryCategoryRepository;

public abstract class CategoriesModuleInfrastructureTestCase extends InventoryContextInfrastructureTestCase {
	protected InMemoryCategoryRepository inMemoryRepository = new InMemoryCategoryRepository();
	@Autowired
	protected CategoryRepository mySqlRepository;
}
