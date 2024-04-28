package dev.ivanhernandez.inventory.products.application.delete;

import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class ProductDeleteCommandHandler implements CommandHandler<ProductDeleteCommand> {
	private final ProductDeleter deleter;

	public ProductDeleteCommandHandler(ProductDeleter deleter) {
		this.deleter = deleter;
	}

	@Override
	public void handle(ProductDeleteCommand command) {
		deleter.delete(new ProductId(command.id()));
	}
}
