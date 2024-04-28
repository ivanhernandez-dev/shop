package dev.ivanhernandez.inventory.products.application.find_all;

import dev.ivanhernandez.shared.domain.bus.query.Query;

import java.util.Objects;

public final class FindAllProductsQuery implements Query {
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return o != null && getClass() == o.getClass();
	}

	@Override
	public int hashCode() {
		return Objects.hash("FindAllProductsQuery");
	}
}
