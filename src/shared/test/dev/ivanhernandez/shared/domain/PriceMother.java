package dev.ivanhernandez.shared.domain;

public final class PriceMother {
	public static String random() {
		return Double.toString(Math.random() * 10000);
	}
}
