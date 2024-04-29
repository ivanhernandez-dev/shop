package dev.ivanhernandez.inventory.warehouse.application.find;

import dev.ivanhernandez.inventory.shared.domain.WarehouseId;
import dev.ivanhernandez.inventory.warehouse.application.WarehouseResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public class FindWarehouseQueryHandler implements QueryHandler<FindWarehouseQuery, WarehouseResponse> {
	private final WarehouseFinder finder;

	public FindWarehouseQueryHandler(WarehouseFinder finder) {
		this.finder = finder;
	}

	@Override
	public WarehouseResponse handle(FindWarehouseQuery query) {
		return finder.find(new WarehouseId(query.getId()));
	}
}
