package dev.ivanhernandez.analytics.domain_events.application.store;

import dev.ivanhernandez.analytics.domain_events.domain.AnalyticsDomainEventAggregateId;
import dev.ivanhernandez.analytics.domain_events.domain.AnalyticsDomainEventBody;
import dev.ivanhernandez.analytics.domain_events.domain.AnalyticsDomainEventId;
import dev.ivanhernandez.analytics.domain_events.domain.AnalyticsDomainEventName;
import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({DomainEvent.class})
public final class StoreDomainEventOnOccurred {
	private final DomainEventStorer storer;

	public StoreDomainEventOnOccurred(DomainEventStorer storer) {
		this.storer = storer;
	}

	@EventListener
	public void on(DomainEvent event) {
		AnalyticsDomainEventId id = new AnalyticsDomainEventId(event.eventId());
		AnalyticsDomainEventAggregateId aggregateId = new AnalyticsDomainEventAggregateId(event.aggregateId());
		AnalyticsDomainEventName name = new AnalyticsDomainEventName(event.eventName());
		AnalyticsDomainEventBody body = new AnalyticsDomainEventBody(event.toPrimitives());

		storer.store(id, aggregateId, name, body);
	}
}
