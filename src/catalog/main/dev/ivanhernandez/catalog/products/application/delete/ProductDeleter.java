package dev.ivanhernandez.catalog.products.application.delete;

import dev.ivanhernandez.catalog.products.application.find.ProductFinder;
import dev.ivanhernandez.catalog.products.domain.ProductRepository;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class ProductDeleter {
	private final ProductRepository repository;
	private final ProductFinder finder;

	public ProductDeleter(ProductRepository repository, ProductFinder finder) {
		this.repository = repository;
		this.finder = finder;
	}

	public void delete(ProductId id) {
		finder.find(id);
		repository.delete(id);
	}
}
