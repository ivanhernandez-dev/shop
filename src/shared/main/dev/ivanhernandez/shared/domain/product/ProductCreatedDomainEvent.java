package dev.ivanhernandez.shared.domain.product;

import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class ProductCreatedDomainEvent extends DomainEvent {
	private final String name;
	private final String price;
	private final String description;
	private final double weight;
	private final String color;
	private final String material;
	private final String categoryId;

	public ProductCreatedDomainEvent() {
		super(null);

		this.name = null;
		this.price = null;
		this.description = null;
		this.weight = 0;
		this.color = null;
		this.material = null;
		this.categoryId = null;
	}

	public ProductCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String price, String description, double weight, String color, String material, String categoryId) {
		super(aggregateId, eventId, occurredOn);
		this.name = name;
		this.price = price;
		this.description = description;
		this.weight = weight;
		this.color = color;
		this.material = material;
		this.categoryId = categoryId;
	}

	public ProductCreatedDomainEvent(String aggregateId, String name, String price, String description, double weight, String color, String material, String categoryId) {
		super(aggregateId);
		this.name = name;
		this.price = price;
		this.description = description;
		this.weight = weight;
		this.color = color;
		this.material = material;
		this.categoryId = categoryId;
	}

	@Override
	public String eventName() {
		return "product.created";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {{
			put("name", name);
			put("price", price);
			put("description", description);
			put("weight", weight);
			put("color", color);
			put("material", material);
			put("categoryId", categoryId);
		}};
	}

	@Override
	public ProductCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new ProductCreatedDomainEvent(
			aggregateId,
			eventId,
			occurredOn,
			(String) body.get("name"),
			(String) body.get("price"),
			(String) body.get("description"),
			(double) body.get("weight"),
			(String) body.get("color"),
			(String) body.get("material"),
			(String) body.get("categoryId")
		);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ProductCreatedDomainEvent that = (ProductCreatedDomainEvent) o;
		return Double.compare(this.weight, that.weight) == 0 && Objects.equals(this.name, that.name) && Objects.equals(this.price, that.price) && Objects.equals(this.description, that.description) && Objects.equals(this.color, that.color) && Objects.equals(this.material, that.material) && Objects.equals(this.categoryId, that.categoryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.price, this.description, this.weight, this.color, this.material, this.categoryId);
	}
}
