package org.student.domain;

import java.util.List;

public class ListStudentsUseCase {
    private final StudentRepository repository;

    public ListStudentsUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> execute() {
        return repository.obtains();
    }
}
