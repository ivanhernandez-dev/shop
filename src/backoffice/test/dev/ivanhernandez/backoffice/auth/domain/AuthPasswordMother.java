package dev.ivanhernandez.backoffice.auth.domain;

import dev.ivanhernandez.shared.domain.WordMother;

public final class AuthPasswordMother {
	public static AuthPassword create(String value) {
		return new AuthPassword(value);
	}

	public static AuthPassword random() {
		return create(WordMother.random());
	}
}
