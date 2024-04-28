package dev.ivanhernandez.apps.inventory.backend.controller.product;

import dev.ivanhernandez.inventory.products.application.ProductsResponse;
import dev.ivanhernandez.inventory.products.application.find_all.FindAllProductsQuery;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class ProductsGetController extends ApiController {
	public ProductsGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/products")
	public List<HashMap<String, String>> index() {
		ProductsResponse products = ask(new FindAllProductsQuery());

		return products
			.products()
			.stream()
			.map(response ->
				new LinkedHashMap<String, String>() {
					{
						put("id", response.id());
						put("name", response.name());
						put("description", response.description());
						put("price", response.price());
						put("stock", response.weight().toString());
						put("color", response.color());
						put("material", response.material());
						put("category_id", response.categoryId());
					}
				}
			)
			.collect(java.util.stream.Collectors.toList());
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>();
	}
}
