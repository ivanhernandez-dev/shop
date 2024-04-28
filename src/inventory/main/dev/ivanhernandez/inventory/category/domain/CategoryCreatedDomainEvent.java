package dev.ivanhernandez.inventory.category.domain;

import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CategoryCreatedDomainEvent extends DomainEvent {
	private final String id;
	private final String name;

	public CategoryCreatedDomainEvent() {
		super(null);

		this.id = null;
		this.name = null;
	}

	public CategoryCreatedDomainEvent(String id, String name) {
		super(id);

		this.id = id;
		this.name = name;
	}

	public CategoryCreatedDomainEvent(String id, String eventId, String occurredOn, String name) {
		super(id, eventId, occurredOn);

		this.id = id;
		this.name = name;
	}

	@Override
	public String eventName() {
		return "category.created";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {{
			put("id", id);
			put("name", name);
		}};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new CategoryCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("name"));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		CategoryCreatedDomainEvent that = (CategoryCreatedDomainEvent) o;
		return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}
}
