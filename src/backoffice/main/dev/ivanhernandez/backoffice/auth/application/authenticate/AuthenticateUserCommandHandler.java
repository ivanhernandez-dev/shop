package dev.ivanhernandez.backoffice.auth.application.authenticate;

import dev.ivanhernandez.backoffice.auth.domain.AuthPassword;
import dev.ivanhernandez.backoffice.auth.domain.AuthUsername;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class AuthenticateUserCommandHandler implements CommandHandler<AuthenticateUserCommand> {
	private final UserAuthenticator authenticator;

	public AuthenticateUserCommandHandler(UserAuthenticator authenticator) {
		this.authenticator = authenticator;
	}

	@Override
	public void handle(AuthenticateUserCommand command) {
		AuthUsername username = new AuthUsername(command.username());
		AuthPassword password = new AuthPassword(command.password());

		authenticator.authenticate(username, password);
	}
}
