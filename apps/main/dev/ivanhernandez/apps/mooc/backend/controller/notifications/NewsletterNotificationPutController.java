package dev.ivanhernandez.apps.mooc.backend.controller.notifications;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ivanhernandez.mooc.notifications.application.send_new_courses_newsletter.SendNewCoursesNewsletterCommand;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandlerExecutionError;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public final class NewsletterNotificationPutController extends ApiController {

	public NewsletterNotificationPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping(value = "/newsletter/{id}")
	public ResponseEntity<String> index(@PathVariable String id) throws CommandHandlerExecutionError {
		dispatch(new SendNewCoursesNewsletterCommand(id));

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
