package dev.ivanhernandez.catalog.products.domain;

import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class ProductNotExist extends DomainError {
	public ProductNotExist(ProductId id) {
		super("product_not_exist", String.format("The product <%s> doesn't exist", id.value()));
	}
}
