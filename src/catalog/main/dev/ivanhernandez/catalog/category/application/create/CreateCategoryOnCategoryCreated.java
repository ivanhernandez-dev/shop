package dev.ivanhernandez.catalog.category.application.create;

import dev.ivanhernandez.shared.domain.category.CategoryCreatedDomainEvent;
import dev.ivanhernandez.catalog.category.domain.CategoryName;
import dev.ivanhernandez.catalog.shared.domain.CategoryId;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@Component
@DomainEventSubscriber({CategoryCreatedDomainEvent.class})
public final class CreateCategoryOnCategoryCreated {
	private final CategoryCreator creator;

	public CreateCategoryOnCategoryCreated(CategoryCreator creator) {
		this.creator = creator;
	}

	@EventListener
	public void on(CategoryCreatedDomainEvent event) {
		System.out.println("Domain event received");
		creator.create(new CategoryId(event.aggregateId()), new CategoryName(event.name()));
	}
}
