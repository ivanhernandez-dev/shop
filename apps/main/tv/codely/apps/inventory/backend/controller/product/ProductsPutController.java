package tv.codely.apps.inventory.backend.controller.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.inventory.products.application.create.CreateProductRequest;
import tv.codely.inventory.products.application.create.ProductCreator;

@RestController
public final class ProductsPutController {
	private ProductCreator creator;

	public ProductsPutController(ProductCreator creator) {
		this.creator = creator;
	}

	@PutMapping("/products/{id}")
	public ResponseEntity create(@PathVariable String id, @RequestBody Request request) {
		this.creator.create(new CreateProductRequest(id, request.name(), request.description(), request.price(), request.weight()));

		return new ResponseEntity(HttpStatus.CREATED);
	}
}

final class Request {
	private String name;
	private String description;
	private String price;
	private Double weight;

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

	public Request(String name, String price, Double weight, String description) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.description = description;
	}
}
