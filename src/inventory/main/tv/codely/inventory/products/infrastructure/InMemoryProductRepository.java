package tv.codely.inventory.products.infrastructure;

import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.domain.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public final class InMemoryProductRepository implements ProductRepository {
	private Map<String, Product> products = new HashMap<>();

	@Override
	public void save(Product product) {
		this.products.put(product.id(), product);
	}

	@Override
	public Optional<Product> search(String id) {
		return Optional.ofNullable(this.products.get(id));
	}
}
