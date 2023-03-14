package compulsory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("Student" + i))
                .toArray(Student[]::new);
        System.out.println("Added " + students.length + " students");


        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("Project" + i) )
                .toArray(Project[]::new);
        System.out.println("Added " + projects.length + " students");

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.addAll(Arrays.stream(students).toList());
        Collections.sort(studentLinkedList,
                ((u, v) -> u.GetName().compareTo(v.GetName())));
        studentLinkedList.forEach((student) -> {
            System.out.println(student.GetName());
        });

        System.out.println("-------------------------------------------");

        TreeSet<Project> projectTreeSet = new TreeSet<>();
        projectTreeSet.addAll(Arrays.stream(projects).toList());

        projectTreeSet.forEach((project -> {
            System.out.println(project.GetName());
        }));
    }
}
