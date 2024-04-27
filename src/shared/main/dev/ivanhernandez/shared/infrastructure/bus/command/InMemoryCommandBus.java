package dev.ivanhernandez.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.Command;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandlerExecutionError;

@Component
public final class InMemoryCommandBus implements CommandBus {
	private final CommandHandlersInformation information;
	private final ApplicationContext context;

	public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
		this.information = information;
		this.context = context;
	}

	@Override
	public void dispatch(Command command) throws CommandHandlerExecutionError {
		try {
			Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

			CommandHandler handler = context.getBean(commandHandlerClass);

			handler.handle(command);
		} catch (Throwable error) {
			throw new CommandHandlerExecutionError(error);
		}
	}
}
