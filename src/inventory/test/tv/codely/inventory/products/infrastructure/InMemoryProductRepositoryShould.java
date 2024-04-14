package tv.codely.inventory.products.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.Product;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryProductRepositoryShould {
	@Test
	void save_a_product() {
		InMemoryProductRepository repository = new InMemoryProductRepository();

		Product product = new Product("1aab45ba-3c7a-4344-8936-78466eca77fa", "The best product", new BigDecimal(100));

		repository.save(product);
	}

	@Test
	void return_an_existing_product() {
		InMemoryProductRepository repository = new InMemoryProductRepository();

		Product product = new Product("1aab45ba-3c7a-4344-8936-78466eca77fa", "The best product", new BigDecimal(100));

		repository.save(product);

		assertEquals(Optional.of(product), repository.search("1aab45ba-3c7a-4344-8936-78466eca77fa"));
	}

	@Test
	void not_return_a_non_existing_product() {
		InMemoryProductRepository repository = new InMemoryProductRepository();

		assertFalse(repository.search("1aab45ba-3c7a-4344-8936-78466eca77fa").isPresent());
	}
}
