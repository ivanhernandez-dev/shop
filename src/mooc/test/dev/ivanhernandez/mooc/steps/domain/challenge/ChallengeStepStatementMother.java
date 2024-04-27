package dev.ivanhernandez.mooc.steps.domain.challenge;

import dev.ivanhernandez.shared.domain.WordMother;

public final class ChallengeStepStatementMother {
	public static ChallengeStepStatement create(String value) {
		return new ChallengeStepStatement(value);
	}

	public static ChallengeStepStatement random() {
		return create(WordMother.random());
	}
}
