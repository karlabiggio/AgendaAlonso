package org.student.domain;

import java.util.List;

public class UpdateStudentUseCase {
    private final StudentRepository repository;

    public UpdateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(String oldName, String newName) {
        List<Student> students = repository.obtains();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(oldName)) {
                s.setName(newName);
            }
        }
        repository.delete(oldName);
        for (Student s : students) {
            repository.add(s);
        }
    }
}
