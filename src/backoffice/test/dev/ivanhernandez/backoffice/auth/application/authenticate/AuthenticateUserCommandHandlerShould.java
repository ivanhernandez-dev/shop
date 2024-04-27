package dev.ivanhernandez.backoffice.auth.application.authenticate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.ivanhernandez.backoffice.auth.AuthModuleUnitTestCase;
import dev.ivanhernandez.backoffice.auth.domain.AuthUser;
import dev.ivanhernandez.backoffice.auth.domain.AuthUserMother;
import dev.ivanhernandez.backoffice.auth.domain.InvalidAuthCredentials;
import dev.ivanhernandez.backoffice.auth.domain.InvalidAuthUsername;

import static org.junit.jupiter.api.Assertions.assertThrows;

final class AuthenticateUserCommandHandlerShould extends AuthModuleUnitTestCase {
	private AuthenticateUserCommandHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		handler = new AuthenticateUserCommandHandler(new UserAuthenticator(repository));
	}

	@Test
	void authenticate_a_valid_user() {
		AuthenticateUserCommand command = AuthenticateUserCommandMother.random();
		AuthUser authUser = AuthUserMother.fromCommand(command);

		shouldSearch(authUser.username(), authUser);

		handler.handle(command);
	}

	@Test
	void throw_an_exception_when_the_user_does_not_exist() {
		assertThrows(InvalidAuthUsername.class, () -> {
			AuthenticateUserCommand command = AuthenticateUserCommandMother.random();
			AuthUser authUser = AuthUserMother.fromCommand(command);

			shouldSearch(authUser.username());

			handler.handle(command);
		});
	}

	@Test
	void throw_an_exception_when_the_password_does_not_math() {
		assertThrows(InvalidAuthCredentials.class, () -> {
			AuthenticateUserCommand command = AuthenticateUserCommandMother.random();
			AuthUser authUser = AuthUserMother.withUsername(command.username());

			shouldSearch(authUser.username(), authUser);

			handler.handle(command);
		});
	}
}
