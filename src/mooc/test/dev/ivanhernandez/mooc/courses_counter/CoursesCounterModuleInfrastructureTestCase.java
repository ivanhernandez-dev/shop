package dev.ivanhernandez.mooc.courses_counter;

import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CoursesCounterModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
	@Autowired
	protected CoursesCounterRepository repository;
}
