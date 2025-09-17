import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.student.data.StudentDataRepository;
import org.student.domain.Student;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDataRepositoryTest {
    private StudentDataRepository repository;

    @BeforeEach
    public void setup() {
        // Borrar el fichero antes de cada test para que empiece limpio
        File file = new File("students.json");
        if (file.exists()) file.delete();

        repository = new StudentDataRepository();
    }

    @Test
    public void addAndGetStudent() {
        Student s1 = new Student("Ana", 101);
        repository.add(s1);

        Student retrieved = repository.getStudent("Ana");
        assertNotNull(retrieved); // no debe ser null
        assertEquals("Ana", retrieved.getName());
        assertEquals(101, retrieved.getFileNumber());
    }

    @Test
    public void deleteStudent() {
        repository.add(new Student("Luis", 202));
        repository.delete("Luis");

        Student s = repository.getStudent("Luis");
        assertNull(s); // debe ser null porque se elimino
    }

    @Test
    public void listStudents() {
        repository.add(new Student("Ana", 101));
        repository.add(new Student("Luis", 202));

        List<Student> students = repository.obtains();
        assertEquals(2, students.size());
    }
}
