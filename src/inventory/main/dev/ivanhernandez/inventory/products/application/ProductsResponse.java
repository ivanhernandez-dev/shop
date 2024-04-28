package dev.ivanhernandez.inventory.products.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Objects;

public final class ProductsResponse implements Response {
	private final List<ProductResponse> products;

	public ProductsResponse(List<ProductResponse> products) {
		this.products = products;
	}

	public List<ProductResponse> products() {
		return products;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ProductsResponse that = (ProductsResponse) o;
		return Objects.equals(this.products, that.products);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.products);
	}
}
