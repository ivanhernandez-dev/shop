package tv.codely.inventory.products;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.infrastructure.UnitTestCase;

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
