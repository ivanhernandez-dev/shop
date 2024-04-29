package dev.ivanhernandez.inventory.products.application.update;

import dev.ivanhernandez.inventory.products.application.create.CreateProductCommand;
import dev.ivanhernandez.inventory.products.application.create.ProductCreator;
import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public class UpdateProductCommandHandler implements CommandHandler<UpdateProductCommand> {
	private final ProductUpdater updater;

	public UpdateProductCommandHandler(ProductUpdater updater) {
		this.updater = updater;
	}

	@Override
	public void handle(UpdateProductCommand command) {
		updater.update(
			new ProductId(command.id()),
			new ProductName(command.name()),
			new ProductDescription(command.description()),
			new ProductPrice(command.price()),
			new ProductWeight(command.weight()),
			new ProductColor(command.color()),
			new ProductMaterial(command.material()),
			new CategoryId(command.categoryId())
		);
	}
}
