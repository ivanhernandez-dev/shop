package dev.ivanhernandez.inventory.products.infrastructure.persistence;

import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.shared.domain.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryProductRepository implements ProductRepository {
	private final Map<String, Product> products = new HashMap<>();

	@Override
	public void save(Product product) {
		this.products.put(product.id().value(), product);
	}

	@Override
	public Optional<Product> search(ProductId id) {
		return Optional.ofNullable(this.products.get(id.value()));
	}

	@Override
	public void update(Product product) {
		if (this.products.containsKey(product.id().value())) {
			this.products.put(product.id().value(), product);
		}
	}

	@Override
	public void delete(ProductId id) {
		this.products.remove(id.value());
	}
}
