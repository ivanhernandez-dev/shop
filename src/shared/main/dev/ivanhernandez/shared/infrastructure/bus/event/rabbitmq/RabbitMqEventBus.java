package dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.List;

@Primary
@Component
public class RabbitMqEventBus implements EventBus {
	private final RabbitMqPublisher publisher;
	private final MySqlEventBus failoverPublisher;
	private final String exchangeName;

	public RabbitMqEventBus(RabbitMqPublisher publisher, MySqlEventBus failoverPublisher) {
		this.publisher = publisher;
		this.failoverPublisher = failoverPublisher;
		this.exchangeName = "domain_events";
	}

	@Override
	public void publish(List<DomainEvent> events) {
		events.forEach(this::publish);
	}

	private void publish(DomainEvent domainEvent) {
		try {
			this.publisher.publish(domainEvent, exchangeName);
		} catch (AmqpException error) {
			failoverPublisher.publish(Collections.singletonList(domainEvent));
		}
	}
}
