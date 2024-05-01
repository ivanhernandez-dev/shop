package dev.ivanhernandez.shared.domain.product;

import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class ProductDeletedDomainEvent extends DomainEvent {

	public ProductDeletedDomainEvent() {
		super(null);
	}

	public ProductDeletedDomainEvent(String aggregateId, String eventId, String occurredOn) {
		super(aggregateId, eventId, occurredOn);
	}

	public ProductDeletedDomainEvent(String aggregateId) {
		super(aggregateId);
	}

	@Override
	public String eventName() {
		return "product.deleted";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<>();
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new ProductDeletedDomainEvent(aggregateId, eventId, occurredOn);
	}
}
