package dev.ivanhernandez.inventory.products;

import org.junit.jupiter.api.BeforeEach;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class ProductsModuleUnitTestCase extends UnitTestCase {
	protected ProductRepository repository;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		repository = mock(ProductRepository.class);
	}

	public void shouldHaveSaved(Product product) {
		verify(repository, atLeastOnce()).save(product);
	}
}
