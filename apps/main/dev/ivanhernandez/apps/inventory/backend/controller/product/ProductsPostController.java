package dev.ivanhernandez.apps.inventory.backend.controller.product;

import dev.ivanhernandez.inventory.products.application.create.CreateProductCommand;
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
public final class ProductsPostController extends ApiController {

	public ProductsPostController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

 	@PostMapping("/products/{id}")
	public ResponseEntity create(@PathVariable String id, @RequestBody Request request) throws CommandHandlerExecutionError {
		dispatch(new CreateProductCommand(
			id,
			request.name(),
			request.description(),
			request.price(),
			request.weight(),
			request.color(),
			request.material(),
			request.categoryId()
		));

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}

final class Request {
	private String name;
	private String description;
	private String price;
	private Double weight;
	private String color;
	private String material;
	private String category_id;

	public Request(String name, String price, Double weight, String description, String color, String material, String categoryId) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.color = color;
		this.material = material;
		this.category_id = categoryId;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public String price() {
		return price;
	}

	public Double weight() {
		return weight;
	}

	public String color() {
		return color;
	}

	public String material() {
		return material;
	}

	public String categoryId() {
		return category_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
}
