package dev.ivanhernandez.shared.domain.category;

import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class CategoryCreatedDomainEvent extends DomainEvent {
	private final String name;

	public CategoryCreatedDomainEvent() {
		super(null);

		this.name = null;
	}

	public CategoryCreatedDomainEvent(String aggregateId, String name) {
		super(aggregateId);

		this.name = name;
	}

	public CategoryCreatedDomainEvent(
		String aggregateId,
		String eventId,
		String occurredOn,
		String name
	) {
		super(aggregateId, eventId, occurredOn);

		this.name = name;
	}

	@Override
	public String eventName() {
		return "category.created";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {{
			put("name", name);
		}};
	}

	@Override
	public CategoryCreatedDomainEvent fromPrimitives(
		String aggregateId,
		HashMap<String, Serializable> body,
		String eventId,
		String occurredOn
	) {
		return new CategoryCreatedDomainEvent(
			aggregateId,
			eventId,
			occurredOn,
			(String) body.get("name")
		);
	}

	public String name() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		CategoryCreatedDomainEvent that = (CategoryCreatedDomainEvent) o;
		return Objects.equals(this.name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.name);
	}
}
