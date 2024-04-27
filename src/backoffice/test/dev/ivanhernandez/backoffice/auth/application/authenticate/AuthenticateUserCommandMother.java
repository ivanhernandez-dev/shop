package dev.ivanhernandez.backoffice.auth.application.authenticate;

import dev.ivanhernandez.backoffice.auth.domain.AuthPassword;
import dev.ivanhernandez.backoffice.auth.domain.AuthPasswordMother;
import dev.ivanhernandez.backoffice.auth.domain.AuthUsername;
import dev.ivanhernandez.backoffice.auth.domain.AuthUsernameMother;

public final class AuthenticateUserCommandMother {
	public static AuthenticateUserCommand create(AuthUsername username, AuthPassword password) {
		return new AuthenticateUserCommand(username.value(), password.value());
	}

	public static AuthenticateUserCommand random() {
		return create(AuthUsernameMother.random(), AuthPasswordMother.random());
	}
}
