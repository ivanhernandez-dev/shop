package tv.codely.inventory.products.domain;

import tv.codely.shared.domain.DomainError;

public final class ProductNotExist extends DomainError {
	public ProductNotExist(ProductId id) {
		super("product_not_exist", String.format("The product <%s> doesn't exist", id.value()));
	}
}
