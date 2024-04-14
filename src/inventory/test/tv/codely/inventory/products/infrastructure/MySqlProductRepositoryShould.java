package tv.codely.inventory.products.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleInfrastructureTestCase;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.products.domain.ProductIdMother;
import tv.codely.inventory.products.domain.ProductMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class MySqlProductRepositoryShould extends ProductsModuleInfrastructureTestCase {
	@Test
	void save_a_product() {
		Product product = ProductMother.random();

		this.mySqlRepository.save(product);
	}

	@Test
	void return_an_existing_product() {
		Product product = ProductMother.random();

		this.mySqlRepository.save(product);

		assertEquals(Optional.of(product), this.mySqlRepository.search(product.id()));
	}

	@Test
	void not_return_a_non_existing_product() {
		ProductId id = ProductIdMother.random();

		assertFalse(this.mySqlRepository.search(id).isPresent());
	}
}
