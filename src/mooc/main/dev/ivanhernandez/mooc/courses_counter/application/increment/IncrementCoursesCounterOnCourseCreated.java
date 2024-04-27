package dev.ivanhernandez.mooc.courses_counter.application.increment;

import org.springframework.context.event.EventListener;
import dev.ivanhernandez.mooc.courses.domain.CourseId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import dev.ivanhernandez.shared.domain.course.CourseCreatedDomainEvent;

@Component
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class IncrementCoursesCounterOnCourseCreated {
	private final CoursesCounterIncrementer incrementer;

	public IncrementCoursesCounterOnCourseCreated(CoursesCounterIncrementer incrementer) {
		this.incrementer = incrementer;
	}

	@EventListener
	public void on(CourseCreatedDomainEvent event) {
		CourseId courseId = new CourseId(event.aggregateId());

		incrementer.increment(courseId);
	}
}
