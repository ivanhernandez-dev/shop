package dev.ivanhernandez.apps.inventory.backend.controller.category;

import dev.ivanhernandez.inventory.category.application.create.CreateCategoryCommand;
import dev.ivanhernandez.inventory.category.domain.CategoryAlreadyExist;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CategoryPostController extends ApiController {
	public CategoryPostController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(CategoryAlreadyExist.class, HttpStatus.CONFLICT);
			}
		};
	}

	@PostMapping("/categories/{id}")
	public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) {
		dispatch(new CreateCategoryCommand(id, request.name()));

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

final class Request {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	String name() {
		return name;
	}
}
