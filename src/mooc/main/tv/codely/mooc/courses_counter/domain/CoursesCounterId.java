package tv.codely.mooc.courses_counter.domain;

import tv.codely.shared.domain.IdentifierValueObject;

public final class CoursesCounterId extends IdentifierValueObject {
    public CoursesCounterId(String value) {
        super(value);
    }

    private CoursesCounterId() {
    }
}
