package dev.ivanhernandez.backoffice.auth;

import dev.ivanhernandez.backoffice.auth.domain.AuthRepository;
import dev.ivanhernandez.backoffice.auth.domain.AuthUser;
import dev.ivanhernandez.backoffice.auth.domain.AuthUsername;
import dev.ivanhernandez.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public abstract class AuthModuleUnitTestCase extends UnitTestCase {
	protected AuthRepository repository;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		repository = mock(AuthRepository.class);
	}

	public void shouldSearch(AuthUsername username, AuthUser user) {
		Mockito.when(repository.search(username)).thenReturn(Optional.of(user));
	}

	public void shouldSearch(AuthUsername username) {
		Mockito.when(repository.search(username)).thenReturn(Optional.empty());
	}
}
