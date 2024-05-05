package dev.ivanhernandez.apps.catalog.backend.controller.product;

import dev.ivanhernandez.catalog.category.domain.CategoryNotExist;
import dev.ivanhernandez.catalog.products.application.ProductResponse;
import dev.ivanhernandez.catalog.products.application.ProductsResponse;
import dev.ivanhernandez.catalog.products.application.find.FindProductQuery;
import dev.ivanhernandez.catalog.products.application.find_all.FindAllProductsQuery;
import dev.ivanhernandez.catalog.products.domain.ProductNotExist;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class ProductGetController extends ApiController {
	public ProductGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/products/{id}")
	public HashMap<String, String> index(@PathVariable String id) {
		ProductResponse product = ask(new FindProductQuery(id));

		return new LinkedHashMap<String, String>() {
			{
				put("id", product.id());
				put("name", product.name());
				put("description", product.description());
				put("price", product.price());
				put("weight", product.weight().toString());
				put("stock", product.weight().toString());
				put("color", product.color());
				put("material", product.material());
				put("category_id", product.categoryId());
				put("is_there_stock", product.isThereStock().toString());
			}
		};
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(ProductNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
