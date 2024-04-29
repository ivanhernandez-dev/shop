package dev.ivanhernandez.inventory.shelves.infrastructure.persistence;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.domain.Shelf;
import dev.ivanhernandez.inventory.shelves.domain.ShelfRepository;
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
	public List<Shelf> searchAll() {
		return super.all();
	}

	@Override
	public void delete(ShelfId id) {
		super.delete(id);
	}
}
