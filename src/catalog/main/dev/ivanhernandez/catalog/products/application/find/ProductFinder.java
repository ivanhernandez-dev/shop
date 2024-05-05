package dev.ivanhernandez.catalog.products.application.find;

import dev.ivanhernandez.catalog.products.application.ProductResponse;
import dev.ivanhernandez.catalog.products.domain.ProductNotExist;
import dev.ivanhernandez.catalog.products.domain.ProductRepository;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.catalog.shared.domain.ProductId;
import dev.ivanhernandez.catalog.stocks.application.check_if_there_is_stock.StockChecker;
import dev.ivanhernandez.shared.domain.Component;

@Component
public class ProductFinder {
	private final ProductRepository repository;
	private final StockChecker stockChecker;

	public ProductFinder(ProductRepository repository, StockChecker stockChecker) {
		this.repository = repository;
		this.stockChecker = stockChecker;
	}

	public ProductResponse find(ProductId id) throws ProductNotExist {
		return repository.search(id)
			.map(product -> ProductResponse.fromAggregate(product, stockChecker.check(product.id()).isThereStock()))
			.orElseThrow(() -> new ProductNotExist(id));
	}
}
