package tv.codely.inventory.shelves.infrastructure.persistence;

import tv.codely.inventory.shelves.domain.Shelf;
import tv.codely.inventory.shared.domain.ShelfId;
import tv.codely.inventory.shelves.domain.ShelfRepository;
import tv.codely.shared.domain.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryShelfRepository implements ShelfRepository {
	private final Map<String, Shelf> shelves = new HashMap<>();

	@Override
	public void save(Shelf shelf) {
		this.shelves.put(shelf.id().value(), shelf);
	}

	@Override
	public Optional<Shelf> search(ShelfId id) {
		return Optional.ofNullable(this.shelves.get(id.value()));
	}

	@Override
	public void update(Shelf shelf) {
		if (this.shelves.containsKey(shelf.id().value())) {
			this.shelves.put(shelf.id().value(), shelf);
		}
	}

	@Override
	public void delete(ShelfId id) {
		this.shelves.remove(id.value());
	}
}
