package org.student.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.student.domain.Student;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentFileLocalDataSource implements StudentData {

    private final String nameFile = "students.json";
    private final Gson gson = new Gson();
    private final Type typeList = new TypeToken<ArrayList<Student>>() {}.getType();

    @Override
    public void save(Student student) {
        List<Student> students = findAll();
        students.add(student);
        saveList(students);
    }

    @Override
    public void saveList(List<Student> studentList) {
        try (FileWriter writer = new FileWriter(nameFile)) {
            gson.toJson(studentList, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar alumnos: " + e.getMessage());
        }
    }

    @Override
    public Student findByName(String name) {
        List<Student> students = findAll();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        File file = new File(nameFile);
        if (!file.exists()) {
            return new ArrayList<Student>();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<Student> students = gson.fromJson(reader, typeList);
            if (students == null) {
                return new ArrayList<Student>();
            }
            return students;
        } catch (IOException e) {
            System.out.println("Error al leer alumnos: " + e.getMessage());
            return new ArrayList<Student>();
        }
    }

    @Override
    public void delete(String modelId) {
        List<Student> students = findAll();
        List<Student> newList = new ArrayList<Student>();
        for (Student s : students) {
            if (!s.getName().equalsIgnoreCase(modelId)) {
                newList.add(s);
            }
        }
        saveList(newList);
    }
}
