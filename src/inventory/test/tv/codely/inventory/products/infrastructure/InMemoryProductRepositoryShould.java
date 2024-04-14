package tv.codely.inventory.products.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleInfrastructureTestCase;
import tv.codely.inventory.products.domain.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryProductRepositoryShould extends ProductsModuleInfrastructureTestCase {
	@Test
	void save_a_product() {
		Product product = ProductMother.random();

		this.repository.save(product);
	}

	@Test
	void return_an_existing_product() {
		Product product = ProductMother.random();

		this.repository.save(product);

		assertEquals(Optional.of(product), this.repository.search(product.id().value()));
	}

	@Test
	void not_return_a_non_existing_product() {
		ProductId id = ProductIdMother.random();

		assertFalse(this.repository.search(id.value()).isPresent());
	}
}
