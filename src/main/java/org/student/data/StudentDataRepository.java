package org.student.data;

import org.student.domain.Student;
import org.student.domain.StudentRepository;

import java.util.List;

public class StudentDataRepository implements StudentRepository {

    private final StudentFileLocalDataSource localDataSource;

    public StudentDataRepository() {
        this.localDataSource = new StudentFileLocalDataSource();
    }

    @Override
    public void add(Student student) {
        localDataSource.save(student);
    }

    @Override
    public void delete(String name) {
        localDataSource.delete(name);
    }

    @Override
    public void update(String oldName, String newName) {
        List<Student> students = localDataSource.findAll();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(oldName)) {
                s.setName(newName); // solo se cambia el nombre, no el expediente, como habias pedido
            }
        }
        localDataSource.saveList(students);
    }

    @Override
    public List<Student> obtains() {
        return localDataSource.findAll();
    }

    @Override
    public Student getStudent(String name) {
        return localDataSource.findByName(name);
    }
}
