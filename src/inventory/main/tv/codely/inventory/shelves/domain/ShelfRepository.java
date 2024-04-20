package tv.codely.inventory.shelves.domain;

import java.util.Optional;

public interface ShelfRepository {
	void save(Shelf shelf);

	Optional<Shelf> search(ShelfId id);

	void delete(ShelfId id);

	void update(Shelf shelf);
}
