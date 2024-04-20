package tv.codely.inventory.shelves.domain;

import tv.codely.shared.domain.AggregateRoot;

public final class Shelf extends AggregateRoot {
	private final ShelfId id;
	private final ShelfLength length;
	private final ShelfWidth width;
	private final ShelfMaxWeight maxWeight;

	public Shelf(ShelfId id, ShelfLength length, ShelfWidth width, ShelfMaxWeight maxWeight) {
		this.id = id;
		this.length = length;
		this.width = width;
		this.maxWeight = maxWeight;
	}

	private Shelf() {
		id = null;
		length = null;
		width = null;
		maxWeight = null;
	}
}
