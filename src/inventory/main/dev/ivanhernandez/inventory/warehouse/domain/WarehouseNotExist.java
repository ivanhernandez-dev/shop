package dev.ivanhernandez.inventory.warehouse.domain;

import dev.ivanhernandez.inventory.shared.domain.WarehouseId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class WarehouseNotExist extends DomainError {
	public WarehouseNotExist(WarehouseId id) {
		super("warehouse_not_exist", String.format("The warehouse <%s> doesn't exist", id.value()));
	}
}
