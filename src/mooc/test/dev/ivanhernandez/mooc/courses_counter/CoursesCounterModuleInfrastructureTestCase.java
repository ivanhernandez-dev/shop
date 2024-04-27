package dev.ivanhernandez.mooc.courses_counter;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterRepository;

public abstract class CoursesCounterModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
	@Autowired
	protected CoursesCounterRepository repository;
}
