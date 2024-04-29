package dev.ivanhernandez.inventory.shelves.domain;

import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class ShelfNotExist extends DomainError {
	public ShelfNotExist(ShelfId id) {
		super("shelf_not_exist", String.format("The shelf <%s> doesn't exist", id.value()));
	}
}
