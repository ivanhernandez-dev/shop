package tv.codely.inventory.warehouse.infrastructure.persistence;

import tv.codely.inventory.shared.domain.WarehouseId;
import tv.codely.inventory.warehouse.domain.Warehouse;
import tv.codely.inventory.warehouse.domain.WarehouseRepository;
import tv.codely.shared.domain.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryWarehouseRepository implements WarehouseRepository {
	private final Map<String, Warehouse> warehouses = new HashMap<>();

	@Override
	public void save(Warehouse warehouse) {
		this.warehouses.put(warehouse.id().value(), warehouse);
	}

	@Override
	public Optional<Warehouse> search(WarehouseId id) {
		return Optional.ofNullable(this.warehouses.get(id.value()));
	}

	@Override
	public void update(Warehouse warehouse) {
		if (this.warehouses.containsKey(warehouse.id().value())) {
			this.warehouses.put(warehouse.id().value(), warehouse);
		}
	}

	@Override
	public void delete(WarehouseId id) {
		this.warehouses.remove(id.value());
	}
}
