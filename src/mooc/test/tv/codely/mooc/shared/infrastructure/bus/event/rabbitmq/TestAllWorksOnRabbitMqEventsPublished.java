package tv.codely.mooc.shared.infrastructure.bus.event.rabbitmq;

import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

@Component
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public Boolean hasBeenExecuted = false;

    public void on(CourseCreatedDomainEvent event) {
        hasBeenExecuted = true;
    }
}
