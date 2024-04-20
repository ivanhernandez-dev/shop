package tv.codely.inventory.products.application.find;

import tv.codely.inventory.products.application.ProductResponse;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.products.domain.ProductNotExist;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.domain.Component;

@Component
public final class ProductFinder {
	private final ProductRepository repository;

	public ProductFinder(ProductRepository repository) {
		this.repository = repository;
	}

	public ProductResponse find(String id) {
		return this.repository.search(new ProductId(id))
			.map(ProductResponse::fromAggregate)
			.orElseThrow(() -> new ProductNotExist(new ProductId(id)));
	}
}
