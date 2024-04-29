package dev.ivanhernandez.inventory.shelves.application.find_all;

import dev.ivanhernandez.inventory.shelves.application.ShelfResponse;
import dev.ivanhernandez.inventory.shelves.application.ShelvesResponse;
import dev.ivanhernandez.inventory.shelves.domain.ShelfRepository;
import dev.ivanhernandez.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllShelvesFinder {
	private final ShelfRepository repository;

	public AllShelvesFinder(ShelfRepository repository) {
		this.repository = repository;
	}

	public ShelvesResponse find() {
		return new ShelvesResponse(
			repository.searchAll().stream().map(ShelfResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
