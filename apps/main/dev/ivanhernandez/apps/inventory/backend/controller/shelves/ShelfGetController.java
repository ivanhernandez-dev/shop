package dev.ivanhernandez.apps.inventory.backend.controller.shelves;

import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.shelves.application.ShelfResponse;
import dev.ivanhernandez.inventory.shelves.application.find.FindShelfQuery;
import dev.ivanhernandez.inventory.shelves.domain.ShelfNotExist;
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
import java.util.LinkedHashMap;

@RestController
public class ShelfGetController extends ApiController {
	public ShelfGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/shelves/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
		throws QueryHandlerExecutionError {
		ShelfResponse shelf = ask(new FindShelfQuery(id));

		return ResponseEntity
			.ok()
			.body(
				new LinkedHashMap<String, Serializable>() {
					{
						put("id", shelf.id());
						put("length", shelf.length());
						put("width", shelf.width());
						put("maxWeight", shelf.maxWeight());
						put("warehouseId", shelf.warehouseId());
					}
				}
			);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(ShelfNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
