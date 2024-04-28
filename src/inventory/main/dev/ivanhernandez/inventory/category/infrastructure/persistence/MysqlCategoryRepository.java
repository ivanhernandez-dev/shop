package dev.ivanhernandez.inventory.category.infrastructure.persistence;

import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryRepository;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
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
public class MysqlCategoryRepository extends HibernateRepository<Category> implements CategoryRepository {
	public MysqlCategoryRepository(@Qualifier("inventory-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Category.class);
	}

	public void save(Category category) {
		super.persist(category);
	}

	public Optional<Category> search(CategoryId id) {
		return super.byId(id);
	}

	public void update(Category category) {
		super.update(category);
	}

	public void delete(CategoryId id) {
		super.delete(id);
	}

	public List<Category> searchAll() {
		return super.all();
	}
}
