package tv.codely.inventory.shelves.infrastructure.persistence.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.inventory.shelves.domain.Shelf;
import tv.codely.inventory.shelves.domain.ShelfId;
import tv.codely.inventory.shelves.domain.ShelfRepository;
import tv.codely.shared.domain.Component;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Primary
@Component
@Transactional("inventory-transaction_manager")
public class MySqlShelfRepository extends HibernateRepository<Shelf> implements ShelfRepository {
	public MySqlShelfRepository(@Qualifier("inventory-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Shelf.class);
	}

	@Override
	public void save(Shelf shelf) {
		super.persist(shelf);
	}

	@Override
	public Optional<Shelf> search(ShelfId id) {
		return super.byId(id);
	}

	@Override
	public void update(Shelf shelf) {
		super.update(shelf);
	}

	@Override
	public void delete(ShelfId id) {
		super.delete(id);
	}
}
