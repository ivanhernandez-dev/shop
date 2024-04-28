package dev.ivanhernandez.inventory.products.domain;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.DomainError;

public final class ProductAlreadyExist extends DomainError {
	public ProductAlreadyExist(ProductId id) {
		super("product_already_exist", String.format("The product <%s> already exist", id.value()));
	}
}
