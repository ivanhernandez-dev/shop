package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductCreatedDomainEventMother;
import dev.ivanhernandez.inventory.products.domain.ProductMother;
import dev.ivanhernandez.shared.domain.product.ProductCreatedDomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ProductCreatorShould extends ProductsModuleUnitTestCase {
	private ProductCreator creator;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		this.creator = new ProductCreator(this.repository, this.eventBus);
	}


	@Test
	void save_a_valid_product() {
		CreateProductRequest request = CreateProductRequestMother.random();

		Product product = ProductMother.fromRequest(request);
		ProductCreatedDomainEvent event = ProductCreatedDomainEventMother.fromProduct(product);

		this.creator.create(request);

		this.shouldHaveSaved(product);
		this.shouldHavePublished(event);
	}
}
