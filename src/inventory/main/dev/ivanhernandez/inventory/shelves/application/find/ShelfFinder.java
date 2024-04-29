package dev.ivanhernandez.inventory.shelves.application.find;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.shelves.application.ShelfResponse;
import dev.ivanhernandez.inventory.shelves.domain.ShelfNotExist;
import dev.ivanhernandez.inventory.shelves.domain.ShelfRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class ShelfFinder {
	private final ShelfRepository repository;

	public ShelfFinder(ShelfRepository repository) {
		this.repository = repository;
	}

	public ShelfResponse find(ShelfId id) {
		return repository.search(id)
			.map(ShelfResponse::fromAggregate)
			.orElseThrow(() -> new ShelfNotExist(id));
	}
}
