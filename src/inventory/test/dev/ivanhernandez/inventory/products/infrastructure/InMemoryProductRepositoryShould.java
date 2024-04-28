package dev.ivanhernandez.inventory.products.infrastructure;

import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.products.ProductsModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void return_all_products() {
		Category category = CategoryMother.random();
		this.categoryRepository.save(category);

		Product product1 = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());
		Product product2 = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());
		Product product3 = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());

		this.mySqlRepository.save(product1);
		this.mySqlRepository.save(product2);
		this.mySqlRepository.save(product3);

		List<Product> products = List.of(product1, product2, product3);
		List<Product> foundProducts = this.mySqlRepository.searchAll();

		assertTrue(foundProducts.containsAll(products));
	}
}
