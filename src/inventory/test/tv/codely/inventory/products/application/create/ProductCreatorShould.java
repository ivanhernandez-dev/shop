package tv.codely.inventory.products.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductRepository;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

final class ProductCreatorShould {
	@Test
	void save_a_valid_product() throws Exception {
		ProductRepository repository = mock(ProductRepository.class);
		ProductCreator creator = new ProductCreator(repository);

		Product product = new Product("1aab45ba-3c7a-4344-8936-78466eca77fa", "The best product", new BigDecimal(100));

		creator.create(product.id(), product.name(), product.price());

		verify(repository, atLeastOnce()).save(product);
	}
}
