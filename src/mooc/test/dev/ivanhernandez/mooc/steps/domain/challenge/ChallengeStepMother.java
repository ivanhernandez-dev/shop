package dev.ivanhernandez.mooc.steps.domain.challenge;

import dev.ivanhernandez.mooc.steps.domain.StepId;
import dev.ivanhernandez.mooc.steps.domain.StepIdMother;
import dev.ivanhernandez.mooc.steps.domain.StepTitle;
import dev.ivanhernandez.mooc.steps.domain.StepTitleMother;

public final class ChallengeStepMother {
	public static ChallengeStep create(StepId id, StepTitle title, ChallengeStepStatement statement) {
		return new ChallengeStep(id, title, statement);
	}

	public static ChallengeStep random() {
		return create(StepIdMother.random(), StepTitleMother.random(), ChallengeStepStatementMother.random());
	}
}
