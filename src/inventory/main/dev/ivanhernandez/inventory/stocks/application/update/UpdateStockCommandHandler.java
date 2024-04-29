package dev.ivanhernandez.inventory.stocks.application.update;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.domain.StockQuantity;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class UpdateStockCommandHandler implements CommandHandler<UpdateStockCommand> {
	private final StockUpdater updater;

	public UpdateStockCommandHandler(StockUpdater updater) {
		this.updater = updater;
	}

	@Override
	public void handle(UpdateStockCommand command) {
		updater.update(new ShelfId(command.shelfId()), new StockQuantity(command.quantity()), new ProductId(command.productId()));
	}
}
