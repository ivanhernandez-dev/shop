package tv.codely.apps.inventory.backend.controller.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.inventory.products.application.create.CreateProductRequest;
import tv.codely.inventory.products.application.create.ProductCreator;

import java.math.BigDecimal;

@RestController
public final class ProductsPutController {
	private ProductCreator creator;

	public ProductsPutController(ProductCreator creator) {
		this.creator = creator;
	}

	@PutMapping("/products/{id}")
	public ResponseEntity create(@PathVariable String id, @RequestBody Request request) {
		this.creator.create(new CreateProductRequest(id, request.name(), request.price()));

		return new ResponseEntity(HttpStatus.CREATED);
	}
}

final class Request {
	private String name;
	private BigDecimal price;

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	String name() {
		return name;
	}

	BigDecimal price() {
		return price;
	}
}
