package tv.codely.inventory.category.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.inventory.category.domain.Category;
import tv.codely.inventory.category.domain.CategoryId;
import tv.codely.inventory.category.domain.CategoryRepository;
import tv.codely.shared.domain.Component;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

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
}
