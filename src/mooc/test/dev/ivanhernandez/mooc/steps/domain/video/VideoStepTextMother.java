package dev.ivanhernandez.mooc.steps.domain.video;

import dev.ivanhernandez.shared.domain.WordMother;

public final class VideoStepTextMother {
	public static VideoStepText create(String value) {
		return new VideoStepText(value);
	}

	public static VideoStepText random() {
		return create(WordMother.random());
	}
}
