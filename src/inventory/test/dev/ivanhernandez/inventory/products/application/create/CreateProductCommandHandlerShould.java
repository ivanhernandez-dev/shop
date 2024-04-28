package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductCreatedDomainEventMother;
import dev.ivanhernandez.inventory.products.domain.ProductMother;
import dev.ivanhernandez.shared.domain.product.ProductCreatedDomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


final class CreateProductCommandHandlerShould extends ProductsModuleUnitTestCase {
	private CreateProductCommandHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		handler = new CreateProductCommandHandler(new ProductCreator(repository, eventBus));
	}

	@Test
	void create_a_valid_product() {
		CreateProductCommand command = CreateProductCommandMother.random();

		Product product = ProductMother.fromRequest(command);
		ProductCreatedDomainEvent domainEvent = ProductCreatedDomainEventMother.fromProduct(product);

		handler.handle(command);

		shouldHaveSaved(product);
		shouldHavePublished(domainEvent);
	}

}
