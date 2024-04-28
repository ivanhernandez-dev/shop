package dev.ivanhernandez.inventory.category;

import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class CategoriesModuleUnitTestCase extends UnitTestCase {
	protected CategoryRepository repository;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		repository = mock(CategoryRepository.class);
	}
}
