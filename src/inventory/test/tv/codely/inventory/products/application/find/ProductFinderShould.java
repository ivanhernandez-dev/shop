package tv.codely.inventory.products.application.find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.ProductsModuleUnitTestCase;
import tv.codely.inventory.products.application.ProductResponse;
import tv.codely.inventory.products.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class ProductFinderShould extends ProductsModuleUnitTestCase {
	private ProductFinder finder;

	@BeforeEach
	protected void setUp() {
		super.setUp();

        this.finder = new ProductFinder(this.repository);
	}

	@Test
	void it_should_find_an_existing_product() {
		Product existingProduct = ProductMother.random();

		when(this.repository.search(existingProduct.id())).thenReturn(Optional.of(existingProduct));

		assertDoesNotThrow(() -> this.finder.find(existingProduct.id().value()));
		verify(this.repository, atLeastOnce()).search(existingProduct.id());
	}

	@Test
	void it_should_throw_an_exception_when_the_product_does_not_exist() {
		ProductId id = ProductIdMother.random();

		assertThrows(ProductNotExist.class, () -> this.finder.find(id.value()));
		verify(this.repository, atLeastOnce()).search(id);
	}

	@Test
	void it_should_return_a_response_with_the_existing_product_data() {
		Product existingProduct = ProductMother.random();

		when(this.repository.search(existingProduct.id())).thenReturn(Optional.of(existingProduct));

		ProductResponse response = this.finder.find(existingProduct.id().value());

		assertAll(
			() -> assertEquals(existingProduct.id().value(), response.id()),
			() -> assertEquals(existingProduct.name().value(), response.name()),
			() -> assertEquals(existingProduct.description().value(), response.description()),
			() -> assertEquals(existingProduct.price().value(), response.price()),
			() -> assertEquals(existingProduct.weight().value(), response.weight())
		);
	}
}
