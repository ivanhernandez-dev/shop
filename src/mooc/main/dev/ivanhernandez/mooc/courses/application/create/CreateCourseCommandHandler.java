package dev.ivanhernandez.mooc.courses.application.create;

import dev.ivanhernandez.mooc.courses.domain.CourseDuration;
import dev.ivanhernandez.mooc.courses.domain.CourseId;
import dev.ivanhernandez.mooc.courses.domain.CourseName;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {
	private final CourseCreator creator;

	public CreateCourseCommandHandler(CourseCreator creator) {
		this.creator = creator;
	}

	@Override
	public void handle(CreateCourseCommand command) {
		CourseId id = new CourseId(command.id());
		CourseName name = new CourseName(command.name());
		CourseDuration duration = new CourseDuration(command.duration());

		creator.create(id, name, duration);
	}
}
