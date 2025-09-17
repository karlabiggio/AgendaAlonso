package org.student.presentation;

import org.student.data.StudentDataRepository;
import org.student.domain.*;

import java.util.List;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDataRepository repository = new StudentDataRepository();

        AddStudentUseCase addStudent = new AddStudentUseCase(repository);
        DeleteStudentUseCase deleteStudent = new DeleteStudentUseCase(repository);
        UpdateStudentUseCase updateStudent = new UpdateStudentUseCase(repository);
        GetStudentUseCase getStudent = new GetStudentUseCase(repository);
        ListStudentsUseCase listStudents = new ListStudentsUseCase(repository);

        int opcion;

        do {
            System.out.println("Menu Alumno, inserta el numero de la operacion que quieres realizar:");
            System.out.println("1. Aniadir Alumno");
            System.out.println("2. Consultar Alumno");
            System.out.println("3. Eliminar Alumno");
            System.out.println("4. Modificar Alumno");
            System.out.println("5. Listar todos");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Numero de expediente: ");
                    int fileNumber = sc.nextInt();
                    addStudent.execute(name, fileNumber);
                    break;

                case 2:
                    System.out.print("Introduce el nombre a consultar: ");
                    String searchName = sc.nextLine();
                    Student s = getStudent.execute(searchName);
                    if (s != null) {
                        System.out.println(s);
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce el nombre a eliminar: ");
                    String deleteName = sc.nextLine();
                    deleteStudent.execute(deleteName);
                    System.out.println("Alumno eliminado (si existia).");
                    break;

                case 4:
                    System.out.print("Introduce el nombre a modificar: ");
                    String oldName = sc.nextLine();
                    System.out.print("Introduce el nuevo nombre: ");
                    String newName = sc.nextLine();
                    updateStudent.execute(oldName, newName);
                    System.out.println("Nombre del alumno actualizado.");
                    break;


                case 5:
                    List<Student> students = listStudents.execute();
                    if (students.isEmpty()) {
                        System.out.println("No hay alumnos registrados.");
                    } else {
                        for (Student st : students) {
                            System.out.println(st);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
