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

	public void create(CreateProductRequest request) {
		Product product = Product.create(request.id(), request.name(), request.price());

		repository.save(product);
	}
}
