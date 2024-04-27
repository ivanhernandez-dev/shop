package dev.ivanhernandez.mooc.shared.infrastructure.bus.event.rabbitmq;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.course.CourseCreatedDomainEvent;

@Component
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
	public Boolean hasBeenExecuted = false;

	public void on(CourseCreatedDomainEvent event) {
		hasBeenExecuted = true;
	}
}
