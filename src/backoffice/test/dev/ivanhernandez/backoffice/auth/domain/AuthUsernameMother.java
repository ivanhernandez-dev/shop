package dev.ivanhernandez.backoffice.auth.domain;

import dev.ivanhernandez.shared.domain.WordMother;

public final class AuthUsernameMother {
	public static AuthUsername create(String value) {
		return new AuthUsername(value);
	}

	public static AuthUsername random() {
		return create(WordMother.random());
	}
}
