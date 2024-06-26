package dev.ivanhernandez.inventory.products.infrastructure;

import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryMother;
import dev.ivanhernandez.inventory.category.domain.CategoryNameMother;
import dev.ivanhernandez.inventory.products.ProductsModuleInfrastructureTestCase;
import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryIdMother;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class MySqlProductRepositoryShould extends ProductsModuleInfrastructureTestCase {
	@Test
	void save_a_product() {
		Category category = CategoryMother.random();
		this.categoryRepository.save(category);

		Product product = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());

		assertEquals(Optional.empty(), this.mySqlRepository.search(product.id()));

		this.mySqlRepository.save(product);

		assertEquals(Optional.of(product), this.mySqlRepository.search(product.id()));
	}

	@Test
	void return_an_existing_product() {
		Category category = CategoryMother.random();
		this.categoryRepository.save(category);

		Product product = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());
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
		Category category = CategoryMother.random();
		this.categoryRepository.save(category);

		Product product = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());
		this.mySqlRepository.save(product);

		this.mySqlRepository.delete(product.id());

		assertFalse(this.mySqlRepository.search(product.id()).isPresent());
	}

	@Test
	void update_a_product() {
		Category category = CategoryMother.random();
		this.categoryRepository.save(category);

		Product product = ProductMother.create(ProductIdMother.random(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), category.id());
		this.mySqlRepository.save(product);

		Category newCategory = CategoryMother.create(CategoryIdMother.random(), CategoryNameMother.random());
		this.categoryRepository.save(newCategory);

		Product updatedProduct = ProductMother.create(product.id(), ProductNameMother.random(), ProductPriceMother.random(), ProductDescriptionMother.random(), ProductWeightMother.random(), ProductColorMother.random(), ProductMaterialMother.random(), newCategory.id());
		this.mySqlRepository.update(updatedProduct);

		assertEquals(Optional.of(updatedProduct), this.mySqlRepository.search(product.id()));
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
