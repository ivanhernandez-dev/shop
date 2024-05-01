package dev.ivanhernandez.inventory.shared.infrastructure.bus.event.rabbitmq;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.category.CategoryCreatedDomainEvent;

@Component
@DomainEventSubscriber({CategoryCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public Boolean hasBeenExecuted = false;

    public void on(CategoryCreatedDomainEvent event) {
		hasBeenExecuted = true;
	}
}
