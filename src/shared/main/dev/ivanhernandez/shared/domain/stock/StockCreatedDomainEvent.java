package dev.ivanhernandez.shared.domain.stock;

import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class StockCreatedDomainEvent extends DomainEvent {
	private final String productId;
	private final String shelfId;
	private final Integer quantity;

	public StockCreatedDomainEvent() {
		super(null);

		this.productId = null;
		this.shelfId = null;
		this.quantity = null;
	}

	public StockCreatedDomainEvent(String aggregateId, String productId, String shelfId, Integer quantity) {
		super(aggregateId);

		this.productId = productId;
		this.shelfId = shelfId;
		this.quantity = quantity;
	}

	public StockCreatedDomainEvent(
		String aggregateId,
		String eventId,
		String occurredOn,
		String productId,
		String shelfId,
		Integer quantity
	) {
		super(aggregateId, eventId, occurredOn);

		this.productId = productId;
		this.shelfId = shelfId;
		this.quantity = quantity;
	}

	@Override
	public String eventName() {
		return "stock.created";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {{
			put("productId", productId);
			put("shelfId", shelfId);
			put("quantity", quantity);
		}};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new StockCreatedDomainEvent(
			aggregateId,
			eventId,
			occurredOn,
			(String) body.get("productId"),
			(String) body.get("shelfId"),
			(Integer) body.get("quantity")
		);
	}

	public String productId() {
		return this.productId;
	}

	public String shelfId() {
		return this.shelfId;
	}

	public Integer quantity() {
		return this.quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		StockCreatedDomainEvent that = (StockCreatedDomainEvent) o;
		return Objects.equals(this.productId, that.productId) && Objects.equals(this.shelfId, that.shelfId) && Objects.equals(this.quantity, that.quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.productId, this.shelfId, this.quantity);
	}
}
