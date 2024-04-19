package tv.codely.inventory.shelves.domain;

import tv.codely.inventory.products.domain.Product;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Collection;

public final class Shelf extends AggregateRoot {
	private final ShelfId id;
	private final ShelfLength length;
	private final ShelfWidth width;
	private final ShelfMaxWeight maxWeight;
	private final Collection<Product> products;

	public Shelf(ShelfId id, ShelfLength length, ShelfWidth width, ShelfMaxWeight maxWeight, Collection<Product> products) {
		this.id = id;
		this.length = length;
		this.width = width;
		this.maxWeight = maxWeight;
		this.products = products;
	}

	private Shelf() {
		id = null;
		length = null;
		width = null;
		maxWeight = null;
		products = null;
	}
}
