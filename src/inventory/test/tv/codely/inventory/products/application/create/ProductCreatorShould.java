package tv.codely.inventory.products.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleUnitTestCase;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductCreatedDomainEventMother;
import tv.codely.inventory.products.domain.ProductMother;
import tv.codely.shared.domain.product.ProductCreatedDomainEvent;

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
