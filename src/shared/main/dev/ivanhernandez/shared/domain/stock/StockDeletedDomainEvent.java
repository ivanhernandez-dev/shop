package dev.ivanhernandez.shared.domain.stock;

import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class StockDeletedDomainEvent extends DomainEvent {
	private final String productId;
	private final String shelfId;

	public StockDeletedDomainEvent() {
		super(null);

		this.productId = null;
		this.shelfId = null;
	}

	public StockDeletedDomainEvent(String aggregateId, String productId, String shelfId) {
		super(aggregateId);

		this.productId = productId;
		this.shelfId = shelfId;
	}

	public StockDeletedDomainEvent(
		String aggregateId,
		String eventId,
		String occurredOn,
		String productId,
		String shelfId
	) {
		super(aggregateId, eventId, occurredOn);

		this.productId = productId;
		this.shelfId = shelfId;
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
		}};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new StockDeletedDomainEvent(
			aggregateId,
			eventId,
			occurredOn,
			(String) body.get("productId"),
			(String) body.get("shelfId")
		);
	}

	public String productId() {
		return this.productId;
	}

	public String shelfId() {
		return this.shelfId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		StockDeletedDomainEvent that = (StockDeletedDomainEvent) o;
		return Objects.equals(this.productId, that.productId) && Objects.equals(this.shelfId, that.shelfId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.productId, this.shelfId);
	}
}
