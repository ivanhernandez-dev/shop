package dev.ivanhernandez.mooc.steps.domain.video;

import dev.ivanhernandez.mooc.steps.domain.StepId;
import dev.ivanhernandez.mooc.steps.domain.StepIdMother;
import dev.ivanhernandez.mooc.steps.domain.StepTitle;
import dev.ivanhernandez.mooc.steps.domain.StepTitleMother;
import dev.ivanhernandez.shared.domain.VideoUrl;
import dev.ivanhernandez.shared.domain.VideoUrlMother;

public final class VideoStepMother {
	public static VideoStep create(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
		return new VideoStep(id, title, videoUrl, text);
	}

	public static VideoStep random() {
		return create(
			StepIdMother.random(),
			StepTitleMother.random(),
			VideoUrlMother.random(),
			VideoStepTextMother.random()
		);
	}
}
