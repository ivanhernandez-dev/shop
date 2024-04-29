package dev.ivanhernandez.apps.inventory.backend.controller.stock;

public final class StockRequest {
	private Integer quantity;

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer quantity() {
		return quantity;
	}
}
