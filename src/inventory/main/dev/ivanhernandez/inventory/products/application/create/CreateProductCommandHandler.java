package dev.ivanhernandez.inventory.products.application.create;

import dev.ivanhernandez.inventory.products.domain.*;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand> {
	private final ProductCreator creator;

	public CreateProductCommandHandler(ProductCreator creator) {
		this.creator = creator;
	}

	@Override
	public void handle(CreateProductCommand command) {
		creator.create(
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
