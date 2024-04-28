package dev.ivanhernandez.inventory.products.application.find_all;

import dev.ivanhernandez.inventory.products.application.ProductResponse;
import dev.ivanhernandez.inventory.products.application.ProductsResponse;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllProductsFinder {
	private final ProductRepository repository;

	public AllProductsFinder(ProductRepository repository) {
		this.repository = repository;
	}

	public ProductsResponse find() {
		return new ProductsResponse(
			repository.searchAll().stream().map(ProductResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
