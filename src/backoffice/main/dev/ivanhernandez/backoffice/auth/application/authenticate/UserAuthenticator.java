package dev.ivanhernandez.backoffice.auth.application.authenticate;

import dev.ivanhernandez.backoffice.auth.domain.*;
import dev.ivanhernandez.shared.domain.Component;

import java.util.Optional;

@Component
public final class UserAuthenticator {
	private final AuthRepository repository;

	public UserAuthenticator(AuthRepository repository) {
		this.repository = repository;
	}

	public void authenticate(AuthUsername username, AuthPassword password) {
		Optional<AuthUser> auth = repository.search(username);

		ensureUserExist(auth, username);
		ensureCredentialsAreValid(auth.get(), password);
	}

	private void ensureUserExist(Optional<AuthUser> auth, AuthUsername username) {
		if (!auth.isPresent()) {
			throw new InvalidAuthUsername(username);
		}
	}

	private void ensureCredentialsAreValid(AuthUser auth, AuthPassword password) {
		if (!auth.passwordMatches(password)) {
			throw new InvalidAuthCredentials(auth.username());
		}
	}
}
