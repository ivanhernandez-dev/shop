package dev.ivanhernandez.inventory.stocks.application.delete;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class DeleteStockCommandHandler implements CommandHandler<DeleteStockCommand> {
	private StockDeleter deleter;

	public DeleteStockCommandHandler(StockDeleter deleter) {
		this.deleter = deleter;
	}

	@Override
	public void handle(DeleteStockCommand command) {
		deleter.delete(new ShelfId(command.shelfId()), new ProductId(command.productId()));
	}
}
