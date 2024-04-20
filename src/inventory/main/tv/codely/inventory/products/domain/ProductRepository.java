package tv.codely.inventory.products.domain;

import java.util.Optional;

public interface ProductRepository {
	void save(Product product);

	Optional<Product> search(ProductId id);

	void update(Product product);

	void delete(ProductId id);
}
