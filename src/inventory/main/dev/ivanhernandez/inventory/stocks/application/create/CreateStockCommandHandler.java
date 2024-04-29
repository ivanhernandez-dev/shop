package dev.ivanhernandez.inventory.stocks.application.create;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.domain.StockQuantity;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class CreateStockCommandHandler implements CommandHandler<CreateStockCommand> {
	private StockCreator creator;

	public CreateStockCommandHandler(StockCreator creator) {
		this.creator = creator;
	}

	@Override
	public void handle(CreateStockCommand command) {
		creator.create(new ShelfId(command.shelfId()), new StockQuantity(command.quantity()), new ProductId(command.productId()));
	}
}
