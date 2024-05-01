package dev.ivanhernandez.apps.catalog.backend.controller.category;

import dev.ivanhernandez.catalog.category.application.CategoriesResponse;
import dev.ivanhernandez.catalog.category.application.find_all.FindAllCategoriesQuery;
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
public final class CategoriesGetController extends ApiController {
	public CategoriesGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/categories")
	public List<HashMap<String, String>> index() {
		CategoriesResponse categories = ask(new FindAllCategoriesQuery());

		return categories
			.categories()
			.stream()
			.map(response ->
				new LinkedHashMap<String, String>() {
					{
						put("id", response.id());
						put("name", response.name());
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
