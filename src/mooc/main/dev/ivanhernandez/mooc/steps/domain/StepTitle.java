package dev.ivanhernandez.mooc.steps.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class StepTitle extends StringValueObject {
	public StepTitle(String value) {
		super(value);
	}

	private StepTitle() {
		super(null);
	}
}
