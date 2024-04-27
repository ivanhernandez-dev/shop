package dev.ivanhernandez.mooc.courses.application.create;

import dev.ivanhernandez.mooc.courses.domain.*;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;

@Component
public final class CourseCreator {
	private final CourseRepository repository;
	private final EventBus eventBus;

	public CourseCreator(CourseRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}

	public void create(CourseId id, CourseName name, CourseDuration duration) {
		Course course = Course.create(id, name, duration);

		repository.save(course);
		eventBus.publish(course.pullDomainEvents());
	}
}
