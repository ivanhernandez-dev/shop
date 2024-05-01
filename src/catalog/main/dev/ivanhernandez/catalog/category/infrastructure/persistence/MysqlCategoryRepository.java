package dev.ivanhernandez.catalog.category.infrastructure.persistence;

import dev.ivanhernandez.catalog.category.domain.Category;
import dev.ivanhernandez.catalog.category.domain.CategoryRepository;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
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
@Transactional("catalog-transaction_manager")
public class MysqlCategoryRepository extends HibernateRepository<Category> implements CategoryRepository {
	public MysqlCategoryRepository(@Qualifier("catalog-session_factory") SessionFactory sessionFactory) {
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
