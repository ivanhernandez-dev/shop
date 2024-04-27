package tv.codely.inventory.products.infrastructure;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import tv.codely.inventory.category.domain.Category;
import tv.codely.inventory.category.domain.CategoryMother;
import tv.codely.inventory.category.domain.CategoryNameMother;
import tv.codely.inventory.products.ProductsModuleInfrastructureTestCase;
import tv.codely.inventory.products.domain.*;
import tv.codely.inventory.shared.domain.CategoryIdMother;
import tv.codely.inventory.shared.domain.ProductId;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
