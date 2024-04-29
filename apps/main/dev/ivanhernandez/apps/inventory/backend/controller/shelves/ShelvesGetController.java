package dev.ivanhernandez.apps.inventory.backend.controller.shelves;

import dev.ivanhernandez.inventory.shelves.application.ShelvesResponse;
import dev.ivanhernandez.inventory.shelves.application.find_all.FindAllShelvesQuery;
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
public final class ShelvesGetController extends ApiController {
	public ShelvesGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/shelves")
	public List<HashMap<String, String>> index() {
		ShelvesResponse shelves = ask(new FindAllShelvesQuery());

		return shelves
			.shelves()
			.stream()
			.map(response ->
				new LinkedHashMap<String, String>() {
					{
						put("id", response.id());
						put("length", response.length().toString());
						put("width", response.width().toString());
						put("maxWeight", response.maxWeight().toString());
						put("warehouseId", response.warehouseId());
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
