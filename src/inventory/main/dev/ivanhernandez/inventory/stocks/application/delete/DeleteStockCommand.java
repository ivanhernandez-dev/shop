package dev.ivanhernandez.inventory.stocks.application.delete;

import dev.ivanhernandez.shared.domain.bus.command.Command;

public final class DeleteStockCommand implements Command {
	private final String shelfId;
	private final String productId;

	public DeleteStockCommand(String shelfId, String productId) {
		this.shelfId = shelfId;
		this.productId = productId;
	}

	public String shelfId() {
		return shelfId;
	}

	public String productId() {
		return productId;
	}
}
