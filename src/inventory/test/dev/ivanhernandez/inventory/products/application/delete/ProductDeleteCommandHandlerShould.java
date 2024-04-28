package dev.ivanhernandez.inventory.products.application.delete;

import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.application.find.ProductFinder;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductMother;
import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class ProductDeleteCommandHandlerShould extends ProductsModuleUnitTestCase {
	private ProductDeleteCommandHandler handler;
	private ProductFinder finder;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		finder = Mockito.mock(ProductFinder.class);
		handler = new ProductDeleteCommandHandler(new ProductDeleter(repository, finder));
	}

	@Test
	void delete_a_valid_product() {
		Product product = ProductMother.random();
		ProductDeleteCommand command = ProductDeleteCommandMother.create(product.id());

		Mockito.when(finder.find(product.id())).thenReturn(ProductResponse.fromAggregate(product));

		handler.handle(command);

		assertEquals(Optional.empty(), repository.search(product.id()));
	}

	@Test
	void throw_an_exception_when_the_product_does_not_exist() {
		ProductDeleteCommand command = ProductDeleteCommandMother.random();

		Mockito.when(finder.find(new ProductId(command.id()))).thenThrow(ProductNotExist.class);

		assertThrows(ProductNotExist.class, () -> handler.handle(command));
	}

	@Test
	void call_repository_delete_method() {
		Product product = ProductMother.random();
		ProductDeleteCommand command = ProductDeleteCommandMother.create(product.id());

		Mockito.when(finder.find(product.id())).thenReturn(ProductResponse.fromAggregate(product));

		handler.handle(command);

		Mockito.verify(repository, Mockito.atLeastOnce()).delete(product.id());
	}

	@Test
	void call_finder_find_method() {
		Product product = ProductMother.random();
		ProductDeleteCommand command = ProductDeleteCommandMother.create(product.id());

		Mockito.when(finder.find(product.id())).thenReturn(ProductResponse.fromAggregate(product));

		handler.handle(command);

		Mockito.verify(finder, Mockito.atLeastOnce()).find(product.id());
	}

	@Test
	void not_throw_exception_when_product_found() {
		Product product = ProductMother.random();
		ProductDeleteCommand command = ProductDeleteCommandMother.create(product.id());

		Mockito.when(finder.find(product.id())).thenReturn(ProductResponse.fromAggregate(product));

		assertDoesNotThrow(() -> handler.handle(command));
	}
}
