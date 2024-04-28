package dev.ivanhernandez.inventory.category.application.create;

import dev.ivanhernandez.inventory.category.domain.Category;
import dev.ivanhernandez.inventory.category.domain.CategoryName;
import dev.ivanhernandez.inventory.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand> {
	private final CategoryCreator creator;

	public CreateCategoryCommandHandler(CategoryCreator creator) {
		this.creator = creator;
	}

	@Override
	public void handle(CreateCategoryCommand command) {
		CategoryId id = new CategoryId(command.id());
		CategoryName name = new CategoryName(command.name());

		creator.create(id, name);
	}
}
