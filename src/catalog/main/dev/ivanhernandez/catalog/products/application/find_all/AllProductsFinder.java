package dev.ivanhernandez.catalog.products.application.find_all;

import dev.ivanhernandez.catalog.products.application.ProductResponse;
import dev.ivanhernandez.catalog.products.application.ProductsResponse;
import dev.ivanhernandez.catalog.products.domain.ProductRepository;
import dev.ivanhernandez.catalog.stocks.application.check_if_there_is_stock.StockChecker;
import dev.ivanhernandez.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllProductsFinder {
	private final ProductRepository repository;
	private final StockChecker stockChecker;

	public AllProductsFinder(ProductRepository repository, StockChecker stockChecker) {
		this.repository = repository;
		this.stockChecker = stockChecker;
	}

	public ProductsResponse find() {
		return new ProductsResponse(
			repository.searchAll()
				.stream()
				.map(product -> ProductResponse.fromAggregate(product, stockChecker.check(product.id()).isThereStock()))
				.collect(Collectors.toList())
		);
	}
}
