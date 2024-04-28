package dev.ivanhernandez.inventory.products.application.find;

import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;

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