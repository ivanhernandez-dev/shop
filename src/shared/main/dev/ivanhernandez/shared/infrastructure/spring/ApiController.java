package dev.ivanhernandez.shared.infrastructure.spring;

import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.Command;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandlerExecutionError;
import dev.ivanhernandez.shared.domain.bus.query.Query;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class ApiController {
	private final QueryBus queryBus;
	private final CommandBus commandBus;

	public ApiController(QueryBus queryBus, CommandBus commandBus) {
		this.queryBus = queryBus;
		this.commandBus = commandBus;
	}

	protected void dispatch(Command command) throws CommandHandlerExecutionError {
		commandBus.dispatch(command);
	}

	protected <R> R ask(Query query) throws QueryHandlerExecutionError {
		return queryBus.ask(query);
	}

	abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
