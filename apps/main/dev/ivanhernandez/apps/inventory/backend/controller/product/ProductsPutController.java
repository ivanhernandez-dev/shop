package dev.ivanhernandez.apps.inventory.backend.controller.product;

import dev.ivanhernandez.inventory.category.domain.CategoryNotExist;
import dev.ivanhernandez.inventory.products.application.create.CreateProductCommand;
import dev.ivanhernandez.inventory.products.application.update.UpdateProductCommand;
import dev.ivanhernandez.inventory.products.domain.ProductAlreadyExist;
import dev.ivanhernandez.inventory.products.domain.ProductNotExist;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandlerExecutionError;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public final class ProductsPutController extends ApiController {

	public ProductsPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

 	@PutMapping("/products/{id}")
	public ResponseEntity update(@PathVariable String id, @RequestBody ProductRequest request) throws CommandHandlerExecutionError {
		dispatch(new UpdateProductCommand(
			id,
			request.name(),
			request.description(),
			request.price(),
			request.weight(),
			request.color(),
			request.material(),
			request.categoryId()
		));

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(ProductNotExist.class, HttpStatus.NOT_FOUND);
				put(CategoryNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}

