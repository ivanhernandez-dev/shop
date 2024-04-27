package dev.ivanhernandez.shared.infrastructure;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.UuidGenerator;

import java.util.UUID;

@Component
public final class JavaUuidGenerator implements UuidGenerator {
	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
