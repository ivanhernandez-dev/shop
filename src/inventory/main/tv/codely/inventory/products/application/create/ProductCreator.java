package tv.codely.inventory.products.application.create;

import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.domain.Service;

import java.math.BigDecimal;

@Service
public final class ProductCreator {
	private final ProductRepository repository;

	public ProductCreator(ProductRepository repository) {
	 	this.repository = repository;
	}

	public void create(String id, String name, BigDecimal price) {
		Product product = Product.create(id, name, price);

		repository.save(product);
	}
}
