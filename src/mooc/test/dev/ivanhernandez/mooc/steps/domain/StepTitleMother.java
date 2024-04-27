package dev.ivanhernandez.mooc.steps.domain;

import dev.ivanhernandez.shared.domain.WordMother;

public final class StepTitleMother {
	public static StepTitle create(String value) {
		return new StepTitle(value);
	}

	public static StepTitle random() {
		return create(WordMother.random());
	}
}
