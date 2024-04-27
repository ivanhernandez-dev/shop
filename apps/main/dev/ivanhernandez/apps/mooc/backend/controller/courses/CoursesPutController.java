package dev.ivanhernandez.apps.mooc.backend.controller.courses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import dev.ivanhernandez.mooc.courses.application.create.CreateCourseCommand;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandlerExecutionError;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public final class CoursesPutController extends ApiController {

	public CoursesPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping(value = "/courses/{id}")
	public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request)
		throws CommandHandlerExecutionError {
		dispatch(new CreateCourseCommand(id, request.name(), request.duration()));

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}

final class Request {

	private String name;
	private String duration;

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name() {
		return name;
	}

	String duration() {
		return duration;
	}
}
