package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;

import java.util.List;
import java.util.Optional;

public interface ShelfRepository {
	void save(Shelf shelf);

	Optional<Shelf> search(ShelfId id);

	void delete(ShelfId id);

	void update(Shelf shelf);

	List<Shelf> searchAll();
}
