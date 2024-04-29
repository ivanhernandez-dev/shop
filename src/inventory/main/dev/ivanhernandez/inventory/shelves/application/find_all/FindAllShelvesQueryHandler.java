package dev.ivanhernandez.inventory.shelves.application.find_all;

import dev.ivanhernandez.inventory.shelves.application.ShelvesResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class FindAllShelvesQueryHandler implements QueryHandler<FindAllShelvesQuery, ShelvesResponse> {
	private final AllShelvesFinder finder;

	public FindAllShelvesQueryHandler(AllShelvesFinder finder) {
		this.finder = finder;
	}

	@Override
	public ShelvesResponse handle(FindAllShelvesQuery query) {
		return finder.find();
	}
}
