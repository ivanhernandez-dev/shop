package tv.codely.inventory.products.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.products.domain.ProductRepository;
import tv.codely.shared.domain.Component;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Primary
@Component
@Transactional("inventory-transaction_manager")
public class MySqlProductRepository extends HibernateRepository<Product> implements ProductRepository {
	public MySqlProductRepository(@Qualifier("inventory-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Product.class);
	}

	@Override
	public void save(Product product) {
		super.persist(product);
	}

	@Override
	public Optional<Product> search(ProductId id) {
		return super.byId(id);
	}

	@Override
	public void update(Product product) {
		super.update(product);
	}

	@Override
	public void delete(ProductId id) {
		super.delete(id);
	}
}
