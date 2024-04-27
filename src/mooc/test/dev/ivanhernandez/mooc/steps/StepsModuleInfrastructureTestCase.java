package dev.ivanhernandez.mooc.steps;

import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.steps.domain.StepRepository;

public abstract class StepsModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
	@Autowired
	protected StepRepository repository;
}
