package org.student.domain;

public class AddStudentUseCase {
    private final StudentRepository repository;

    public AddStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(String name, int fileNumber) {
        repository.add(new Student(name, fileNumber));
    }
}
