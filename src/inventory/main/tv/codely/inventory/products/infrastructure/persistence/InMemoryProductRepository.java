package tv.codely.inventory.products.infrastructure.persistence;

import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.domain.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryProductRepository implements ProductRepository {
	private Map<String, Product> products = new HashMap<>();

	@Override
	public void save(Product product) {
		this.products.put(product.id().value(), product);
	}

	@Override
	public Optional<Product> search(ProductId id) {
		return Optional.ofNullable(this.products.get(id.value()));
	}
}
