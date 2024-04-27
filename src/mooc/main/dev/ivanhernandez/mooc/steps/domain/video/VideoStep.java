package dev.ivanhernandez.mooc.steps.domain.video;

import dev.ivanhernandez.mooc.steps.domain.Step;
import dev.ivanhernandez.mooc.steps.domain.StepId;
import dev.ivanhernandez.mooc.steps.domain.StepTitle;
import dev.ivanhernandez.shared.domain.VideoUrl;

public final class VideoStep extends Step {
	private final VideoUrl videoUrl;
	private final VideoStepText text;

	public VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
		super(id, title);

		this.videoUrl = videoUrl;
		this.text = text;
	}

	private VideoStep() {
		super(null, null);

		this.videoUrl = null;
		this.text = null;
	}
}
