package dev.ivanhernandez.shared.domain;

public final class DoubleMother {
	private static final int DEFAULT_DECIMALS = 2;
	private static final int DEFAULT_MIN = 0;
	private static final int DEFAULT_MAX = 100;

	public static Double random() {
		return DoubleMother.random(DEFAULT_MIN, DEFAULT_MAX);
	}

	public static Double random(int min, int max) {
		return DoubleMother.random(min, max, DEFAULT_DECIMALS);
	}

	public static Double random(int min, int max, int decimals) {
		return MotherCreator.random().number().randomDouble(decimals, min, max);
	}
}
