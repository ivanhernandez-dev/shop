package dev.ivanhernandez.inventory.products.infrastructure.persistence;

import dev.ivanhernandez.inventory.products.domain.Product;
import dev.ivanhernandez.inventory.products.domain.ProductRepository;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

	@Override
	public List<Product> searchAll() {
		return super.all();
	}
}
