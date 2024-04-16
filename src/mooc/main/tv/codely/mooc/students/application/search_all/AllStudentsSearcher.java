package tv.codely.mooc.students.application.search_all;

import tv.codely.mooc.students.application.StudentResponse;
import tv.codely.mooc.students.application.StudentsResponse;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllStudentsSearcher {
    private final StudentRepository repository;

    public AllStudentsSearcher(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentsResponse search() {
        return new StudentsResponse(
            repository.searchAll().stream().map(StudentResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
