package dev.ivanhernandez.inventory.category.application.create;

import dev.ivanhernandez.shared.domain.bus.command.Command;

public final class CreateCategoryCommand implements Command {
	private final String id;
	private final String name;

	public CreateCategoryCommand(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}
}
