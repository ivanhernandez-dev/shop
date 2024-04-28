package dev.ivanhernandez.inventory.products.application.find;

import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductIdMother;
import dev.ivanhernandez.inventory.products.domain.ProductMother;
import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class FindProductQueryHandlerShould extends ProductsModuleUnitTestCase {
	private FindProductQueryHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		this.handler = new FindProductQueryHandler(new ProductFinder(this.repository));
	}

	@Test
	void find_an_existing_product() {
		Product product = ProductMother.random();
		FindProductQuery query = new FindProductQuery(product.id().value());
		ProductResponse response = ProductResponse.fromAggregate(product);

		Mockito.when(this.repository.search(product.id())).thenReturn(Optional.of(product));

		assertEquals(response, this.handler.handle(query));
	}

	@Test
	void throw_an_exception_when_the_product_does_not_exist() {
		FindProductQuery query = new FindProductQuery(ProductIdMother.random().value());

		Mockito.when(this.repository.search(Mockito.any())).thenReturn(Optional.empty());

		assertThrows(ProductNotExist.class, () -> this.handler.handle(query));
	}

	@Test
	void call_repository_search_method() {
		Product product = ProductMother.random();
		FindProductQuery query = new FindProductQuery(product.id().value());

		Mockito.when(this.repository.search(product.id())).thenReturn(Optional.of(product));

		this.handler.handle(query);

		Mockito.verify(this.repository, atLeastOnce()).search(product.id());
	}
}
