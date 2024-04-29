
package dev.ivanhernandez.inventory.stocks.application.update;

import dev.ivanhernandez.shared.domain.bus.command.Command;

public final class UpdateStockCommand implements Command {
	private final String shelfId;
	private final Integer quantity;
	private final String productId;

	public UpdateStockCommand(String shelfId, Integer quantity, String productId) {
		this.shelfId = shelfId;
		this.quantity = quantity;
		this.productId = productId;
	}

	public String shelfId() {
		return shelfId;
	}

	public String productId() {
		return productId;
	}

	public Integer quantity() {
		return quantity;
	}
}
