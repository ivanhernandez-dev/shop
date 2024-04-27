package dev.ivanhernandez.apps.mooc.backend.controller.courses;

import dev.ivanhernandez.mooc.courses.application.CourseResponse;
import dev.ivanhernandez.mooc.courses.application.find.FindCourseQuery;
import dev.ivanhernandez.mooc.courses.domain.CourseNotExist;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandlerExecutionError;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class CourseGetController extends ApiController {

	public CourseGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
		throws QueryHandlerExecutionError {
		CourseResponse course = ask(new FindCourseQuery(id));

		return ResponseEntity
			.ok()
			.body(
				new HashMap<String, Serializable>() {
					{
						put("id", course.id());
						put("name", course.name());
						put("duration", course.duration());
					}
				}
			);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(CourseNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
