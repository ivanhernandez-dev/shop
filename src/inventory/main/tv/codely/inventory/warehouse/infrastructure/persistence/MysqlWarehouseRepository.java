package tv.codely.inventory.warehouse.infrastructure.persistence;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.inventory.warehouse.domain.Warehouse;
import tv.codely.inventory.warehouse.domain.WarehouseRepository;
import tv.codely.shared.domain.Component;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Primary
@Component
@Transactional
public class MysqlWarehouseRepository extends HibernateRepository<Warehouse> implements WarehouseRepository {
	public MysqlWarehouseRepository(@Qualifier("inventory-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Warehouse.class);
	}

	@Override
	public void save(Warehouse warehouse) {
		super.persist(warehouse);
	}

	@Override
	public void update(Warehouse warehouse) {
		super.update(warehouse);
	}

	@Override
	public void delete(WarehouseId id) {
		super.delete(id);
	}

	@Override
	public Optional<Warehouse> search(WarehouseId id) {
		return super.byId(id);
	}
}
