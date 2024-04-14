package tv.codely.inventory.products.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryProductRepositoryShould {
	@Test
	void save_a_product() {
		InMemoryProductRepository repository = new InMemoryProductRepository();

		Product product = ProductMother.random();

		repository.save(product);
	}

	@Test
	void return_an_existing_product() {
		InMemoryProductRepository repository = new InMemoryProductRepository();

		Product product = ProductMother.random();

		repository.save(product);

		assertEquals(Optional.of(product), repository.search(product.id().value()));
	}

	@Test
	void not_return_a_non_existing_product() {
		InMemoryProductRepository repository = new InMemoryProductRepository();
		ProductId id = ProductIdMother.random();

		assertFalse(repository.search(id.value()).isPresent());
	}
}
