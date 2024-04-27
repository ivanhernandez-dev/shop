package dev.ivanhernandez.mooc.courses;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses.domain.CourseRepository;
import dev.ivanhernandez.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;

public abstract class CoursesModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
	protected InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();
	@Autowired
	protected CourseRepository mySqlCourseRepository;
}
