package tv.codely.inventory.products.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleInfrastructureTestCase;
import tv.codely.inventory.products.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryProductRepositoryShould extends ProductsModuleInfrastructureTestCase {
	@Test
	void save_a_product() {
		Product product = ProductMother.random();

		this.inMemoryRepository.save(product);
	}

	@Test
	void return_an_existing_product() {
		Product product = ProductMother.random();

		this.inMemoryRepository.save(product);

		assertEquals(Optional.of(product), this.inMemoryRepository.search(product.id()));
	}

	@Test
	void not_return_a_non_existing_product() {
		ProductId id = ProductIdMother.random();

		assertFalse(this.inMemoryRepository.search(id).isPresent());
	}
}
