package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;

import java.util.Optional;

public interface ProductRepository {
	void save(Product product);

	Optional<Product> search(ProductId id);

	void update(Product product);

	void delete(ProductId id);
}
