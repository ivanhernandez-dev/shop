package tv.codely.inventory.warehouse.domain;

import tv.codely.inventory.shared.domain.WarehouseId;

import java.util.Optional;

public interface WarehouseRepository {
	void save(Warehouse warehouse);

	Optional<Warehouse> search(WarehouseId id);

	void delete(WarehouseId id);

	void update(Warehouse warehouse);
}
