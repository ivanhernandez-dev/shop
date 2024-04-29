package dev.ivanhernandez.inventory.shelves.application.find;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.application.ShelfResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class FindShelfQueryHandler implements QueryHandler<FindShelfQuery, ShelfResponse> {
	private ShelfFinder finder;

	public FindShelfQueryHandler(ShelfFinder finder) {
		this.finder = finder;
	}

	@Override
	public ShelfResponse handle(FindShelfQuery query) {
		return finder.find(new ShelfId(query.id()));
	}
}
