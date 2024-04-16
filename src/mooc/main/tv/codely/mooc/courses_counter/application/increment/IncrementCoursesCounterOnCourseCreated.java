package tv.codely.mooc.courses_counter.application.increment;

import org.springframework.context.event.EventListener;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

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
