package dev.ivanhernandez.inventory.products.application.find_all;

import dev.ivanhernandez.inventory.products.ProductsModuleUnitTestCase;
import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.application.ProductsReponseMother;
import dev.ivanhernandez.inventory.products.application.ProductsResponse;
import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductMother;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class FindAllProductsQueryHandlerShould extends ProductsModuleUnitTestCase {

	private FindAllProductsQueryHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		handler = new FindAllProductsQueryHandler(new AllProductsFinder(repository));
	}

	@Test
	void find_all_products() {
		FindAllProductsQuery query = FindAllProductsQueryMother.random();

		Product product1 = ProductMother.random();
		Product product2 = ProductMother.random();
		Product product3 = ProductMother.random();

		List<Product> products = Arrays.asList(product1, product2, product3);

		List<ProductResponse> productResponses = Arrays.asList(
			ProductResponse.fromAggregate(product1),
			ProductResponse.fromAggregate(product2),
			ProductResponse.fromAggregate(product3)
		);

		ProductsResponse response = ProductsReponseMother.create(productResponses);

		Mockito.when(repository.searchAll()).thenReturn(products);

		assertEquals(response, handler.handle(query));
	}

	@Test
	void call_repository_search_all_method() {
		FindAllProductsQuery query = FindAllProductsQueryMother.random();

		Mockito.when(repository.searchAll()).thenReturn(List.of());

		handler.handle(query);

		Mockito.verify(repository, Mockito.atLeastOnce()).searchAll();
	}
}
