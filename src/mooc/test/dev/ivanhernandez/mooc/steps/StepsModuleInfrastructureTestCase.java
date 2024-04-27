package dev.ivanhernandez.mooc.steps;

import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.steps.domain.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class StepsModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
	@Autowired
	protected StepRepository repository;
}
