package dev.ivanhernandez.apps.mooc.backend.controller.courses_counter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ivanhernandez.mooc.courses_counter.application.find.CoursesCounterResponse;
import dev.ivanhernandez.mooc.courses_counter.application.find.FindCoursesCounterQuery;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandlerExecutionError;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public final class CoursesCounterGetController extends ApiController {

	public CoursesCounterGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/courses-counter")
	public HashMap<String, Integer> index() throws QueryHandlerExecutionError {
		CoursesCounterResponse response = ask(new FindCoursesCounterQuery());

		return new HashMap<String, Integer>() {
			{
				put("total", response.total());
			}
		};
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
