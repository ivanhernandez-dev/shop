package dev.ivanhernandez.backoffice.courses.application.create;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.course.CourseCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@Component
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class CreateBackofficeCourseOnCourseCreated {
	private final BackofficeCourseCreator creator;

	public CreateBackofficeCourseOnCourseCreated(BackofficeCourseCreator creator) {
		this.creator = creator;
	}

	@EventListener
	public void on(CourseCreatedDomainEvent event) {
		creator.create(event.aggregateId(), event.name(), event.duration());
	}
}
