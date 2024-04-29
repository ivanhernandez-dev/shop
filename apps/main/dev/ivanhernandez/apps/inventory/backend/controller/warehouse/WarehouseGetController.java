package dev.ivanhernandez.apps.inventory.backend.controller.warehouse;

import dev.ivanhernandez.inventory.warehouse.application.WarehouseResponse;
import dev.ivanhernandez.inventory.warehouse.application.find.FindWarehouseQuery;
import dev.ivanhernandez.inventory.warehouse.domain.WarehouseNotExist;
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
public class WarehouseGetController extends ApiController {
	public WarehouseGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/warehouses/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
		WarehouseResponse warehouse = ask(new FindWarehouseQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("id", warehouse.id());
				put("name", warehouse.name());
			}
		});
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(WarehouseNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
