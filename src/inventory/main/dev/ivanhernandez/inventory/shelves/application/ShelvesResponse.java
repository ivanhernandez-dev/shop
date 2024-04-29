package dev.ivanhernandez.inventory.shelves.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;

public final class ShelvesResponse implements Response {
	private final List<ShelfResponse> shelves;

	public ShelvesResponse(List<ShelfResponse> shelves) {
		this.shelves = shelves;
	}

	public List<ShelfResponse> shelves() {
		return shelves;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ShelvesResponse shelves = (ShelvesResponse) o;
		return this.shelves.equals(shelves.shelves);
	}

	@Override
	public int hashCode() {
		return shelves.hashCode();
	}
}
