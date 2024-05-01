package dev.ivanhernandez.shared.infrastructure.bus.event.spring;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Component
public class SpringApplicationEventBus implements EventBus {
	private final ApplicationEventPublisher publisher;

	public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public void publish(final List<DomainEvent> events) {
		events.forEach(this::publish);
	}

	private void publish(final DomainEvent event) {
		this.publisher.publishEvent(event);
	}
}
