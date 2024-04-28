package dev.ivanhernandez.inventory.products.application.delete;

import dev.ivanhernandez.shared.domain.bus.command.Command;

public class ProductDeleteCommand implements Command {
	private final String id;

	public ProductDeleteCommand(String id) {
		this.id = id;
	}

	public String id() {
		return id;
	}
}
