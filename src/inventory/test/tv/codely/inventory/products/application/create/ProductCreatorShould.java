package tv.codely.inventory.products.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.*;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

final class ProductCreatorShould {
	@Test
	void save_a_valid_product() throws Exception {
		ProductRepository repository = mock(ProductRepository.class);
		ProductCreator creator = new ProductCreator(repository);

		CreateProductRequest request = CreateProductRequestMother.random();

		Product product = ProductMother.fromRequest(request);

		creator.create(request);

		verify(repository, atLeastOnce()).save(product);
	}
}
