package dev.ivanhernandez.apps.inventory.backend.controller.category;

import dev.ivanhernandez.inventory.category.application.CategoryResponse;
import dev.ivanhernandez.inventory.category.application.find.FindCategoryQuery;
import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandlerExecutionError;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class CategoryGetController extends ApiController {

	public CategoryGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
		throws QueryHandlerExecutionError {
		CategoryResponse category = ask(new FindCategoryQuery(id));

		return ResponseEntity
			.ok()
			.body(
				new HashMap<String, Serializable>() {
					{
						put("id", category.id());
						put("name", category.name());
					}
				}
			);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(CategoryNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
