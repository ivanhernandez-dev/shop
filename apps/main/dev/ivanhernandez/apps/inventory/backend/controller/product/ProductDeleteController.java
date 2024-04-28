package dev.ivanhernandez.apps.inventory.backend.controller.product;

import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.products.application.delete.ProductDeleteCommand;
import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProductDeleteController extends ApiController {
	public ProductDeleteController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		dispatch(new ProductDeleteCommand(id));

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
