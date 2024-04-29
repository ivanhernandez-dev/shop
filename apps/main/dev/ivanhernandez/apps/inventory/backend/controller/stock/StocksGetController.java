package dev.ivanhernandez.apps.inventory.backend.controller.stock;

import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.inventory.shelves.domain.ShelfNotExist;
import dev.ivanhernandez.inventory.stocks.application.StocksResponse;
import dev.ivanhernandez.inventory.stocks.application.find_by_product_id.FindByProductIdStocksQuery;
import dev.ivanhernandez.inventory.stocks.application.find_by_shelf_id.FindByShelfIdStocksQuery;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class StocksGetController extends ApiController {
	public StocksGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/stocks")
	public List<HashMap<String, String>> index(@RequestParam(required = false) String shelf_id, @RequestParam(required = false) String product_id) {
		if (shelf_id != null) {
			FindByShelfIdStocksQuery query = new FindByShelfIdStocksQuery(shelf_id);
			StocksResponse stocks = ask(query);
			return mapStocksToResponse(stocks);
		} else if (product_id != null) {
			FindByProductIdStocksQuery query = new FindByProductIdStocksQuery(product_id);
			StocksResponse stocks = ask(query);
			return mapStocksToResponse(stocks);
		} else {
			throw new IllegalArgumentException("You must provide either a shelf_id or a product_id");
		}
	}

	private List<HashMap<String, String>> mapStocksToResponse(StocksResponse stocks) {
		return stocks
			.stocks()
			.stream()
			.map(response ->
				new LinkedHashMap<String, String>() {
					{
						put("shelf_id", response.shelfId());
						put("quantity", response.quantity().toString());
						put("product_id", response.productId());
					}
				}
			)
			.collect(java.util.stream.Collectors.toList());
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<>() {
			{
				put(ProductNotExist.class, HttpStatus.NOT_FOUND);
				put(ShelfNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
