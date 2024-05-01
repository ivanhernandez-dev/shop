package dev.ivanhernandez.catalog.products.application.find;

import dev.ivanhernandez.catalog.products.application.ProductResponse;
import dev.ivanhernandez.catalog.products.domain.ProductNotExist;
import dev.ivanhernandez.catalog.products.domain.ProductRepository;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.Query;

public final class FindProductQuery implements Query {
	private final String id;

	public FindProductQuery(String id) {
		this.id = id;
	}

	public String id() {
		return id;
	}
}
