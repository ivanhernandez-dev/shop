package dev.ivanhernandez.catalog.products.domain;

import dev.ivanhernandez.catalog.shared.domain.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
	void save(Product product);

	Optional<Product> search(ProductId id);

	void update(Product product);

	void delete(ProductId id);

	List<Product> searchAll();
}
