package dev.ivanhernandez.backoffice.auth.infrastructure.persistence;

import dev.ivanhernandez.backoffice.auth.domain.AuthPassword;
import dev.ivanhernandez.backoffice.auth.domain.AuthRepository;
import dev.ivanhernandez.backoffice.auth.domain.AuthUser;
import dev.ivanhernandez.backoffice.auth.domain.AuthUsername;
import dev.ivanhernandez.shared.domain.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public final class InMemoryAuthRepository implements AuthRepository {
	private final HashMap<AuthUsername, AuthPassword> users = new HashMap<AuthUsername, AuthPassword>() {{
		put(new AuthUsername("javi"), new AuthPassword("barbitas"));
		put(new AuthUsername("rafa"), new AuthPassword("pelazo"));
	}};

	@Override
	public Optional<AuthUser> search(AuthUsername username) {
		return users.containsKey(username)
			? Optional.of(new AuthUser(username, users.get(username)))
			: Optional.empty();
	}
}