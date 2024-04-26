package tv.codely.inventory.products.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleInfrastructureTestCase;
import tv.codely.inventory.products.domain.*;
import tv.codely.inventory.shared.domain.CategoryIdMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryProductRepositoryShould extends ProductsModuleInfrastructureTestCase {
	@Test
	void save_a_product() {
		Product product = ProductMother.random();

		assertEquals(Optional.empty(), this.inMemoryRepository.search(product.id()));

		this.inMemoryRepository.save(product);

		assertEquals(Optional.of(product), this.inMemoryRepository.search(product.id()));
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

	@Test
	void delete_an_existing_product() {
		Product product = ProductMother.random();

		this.inMemoryRepository.save(product);
		this.inMemoryRepository.delete(product.id());

		assertFalse(this.inMemoryRepository.search(product.id()).isPresent());
	}

	@Test
	void update_a_product() {
		Product product = ProductMother.random();
		this.inMemoryRepository.save(product);

		Product updatedProduct = new Product(product.id(), ProductNameMother.random(), ProductDescriptionMother.random(), ProductPriceMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), CategoryIdMother.random());
		this.inMemoryRepository.update(updatedProduct);

		assertEquals(Optional.of(updatedProduct), this.inMemoryRepository.search(product.id()));
	}
}
