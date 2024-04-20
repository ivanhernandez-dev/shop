package tv.codely.shared.domain.product;

import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class ProductCreatedDomainEvent extends DomainEvent {
	private final String name;
	private final String price;

	public ProductCreatedDomainEvent() {
		super(null);

		this.name = null;
		this.price = null;
	}

	public ProductCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String price) {
		super(aggregateId, eventId, occurredOn);
		this.name = name;
		this.price = price;
	}

	public ProductCreatedDomainEvent(String aggregateId, String name, String price) {
		super(aggregateId);
		this.name = name;
		this.price = price;
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
		}};
	}

	@Override
	public ProductCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new ProductCreatedDomainEvent(
			aggregateId,
			eventId,
			occurredOn,
			(String) body.get("name"),
			(String) body.get("price")
		);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductCreatedDomainEvent that = (ProductCreatedDomainEvent) o;
		return Objects.equals(name, that.name) && Objects.equals(price, that.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
}
