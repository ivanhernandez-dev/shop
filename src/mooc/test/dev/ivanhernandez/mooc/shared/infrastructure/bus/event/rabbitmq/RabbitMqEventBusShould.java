package dev.ivanhernandez.mooc.shared.infrastructure.bus.event.rabbitmq;

import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses.domain.CourseCreatedDomainEventMother;
import dev.ivanhernandez.shared.domain.course.CourseCreatedDomainEvent;
import dev.ivanhernandez.shared.infrastructure.bus.event.DomainEventSubscriberInformation;
import dev.ivanhernandez.shared.infrastructure.bus.event.DomainEventSubscribersInformation;
import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class RabbitMqEventBusShould extends MoocContextInfrastructureTestCase {
	@Autowired
	private RabbitMqEventBus eventBus;
	@Autowired
	private RabbitMqDomainEventsConsumer consumer;
	@Autowired
	private TestAllWorksOnRabbitMqEventsPublished subscriber;

	@BeforeEach
	protected void setUp() {
		subscriber.hasBeenExecuted = false;

		consumer.withSubscribersInformation(
			new DomainEventSubscribersInformation(
				new HashMap<Class<?>, DomainEventSubscriberInformation>() {{
					put(TestAllWorksOnRabbitMqEventsPublished.class, new DomainEventSubscriberInformation(
						TestAllWorksOnRabbitMqEventsPublished.class,
						Collections.singletonList(CourseCreatedDomainEvent.class)
					));
				}}
			)
		);
	}

	@Test
	void publish_and_consume_domain_events_from_rabbitmq() throws Exception {
		CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

		eventBus.publish(Collections.singletonList(domainEvent));

		consumer.consume();

		eventually(() -> assertTrue(subscriber.hasBeenExecuted));
	}
}
