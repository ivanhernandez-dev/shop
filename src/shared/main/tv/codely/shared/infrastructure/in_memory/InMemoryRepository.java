package tv.codely.shared.infrastructure.in_memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository<T, ID> {
	private final Map<ID, T> entities = new HashMap<>();

	public void save(ID id, T entity) {
		this.entities.put(id, entity);
	}

	public Optional<T> search(ID id) {
		return Optional.ofNullable(this.entities.get(id));
	}

	public void update(ID id, T entity) {
		if (this.entities.containsKey(id)) {
			this.entities.put(id, entity);
		}
	}

	public void delete(ID id) {
		this.entities.remove(id);
	}
}
