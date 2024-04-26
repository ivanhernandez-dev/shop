package tv.codely.inventory.products.infrastructure;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleInfrastructureTestCase;
import tv.codely.inventory.products.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlProductRepositoryShould extends ProductsModuleInfrastructureTestCase {
	@Test
	void save_a_product() {
		Product product = ProductMother.random();

		assertEquals(Optional.empty(), this.mySqlRepository.search(product.id()));

		this.mySqlRepository.save(product);

		assertEquals(Optional.of(product), this.mySqlRepository.search(product.id()));
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

	@Test
	void delete_an_existing_product() {
		Product product = ProductMother.random();

		this.mySqlRepository.save(product);
		this.mySqlRepository.delete(product.id());

		assertFalse(this.mySqlRepository.search(product.id()).isPresent());
	}

	@Test
	void update_a_product() {
		Product product = ProductMother.random();
		this.mySqlRepository.save(product);

		Product updatedProduct = new Product(product.id(), ProductNameMother.random(), ProductDescriptionMother.random(), ProductPriceMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random());
		this.mySqlRepository.update(updatedProduct);

		assertEquals(Optional.of(updatedProduct), this.mySqlRepository.search(product.id()));
	}
}
