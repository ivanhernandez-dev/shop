package tv.codely.inventory.shelves.domain;

public final class ShelfMother {
	public static Shelf create(ShelfId id, ShelfLength length, ShelfWidth width, ShelfMaxWeight maxWeight) {
		return new Shelf(id, length, width, maxWeight);
	}

	public static Shelf random() {
		return create(ShelfIdMother.random(), ShelfLengthMother.random(), ShelfWidthMother.random(), ShelfMaxWeightMother.random());
	}
}
