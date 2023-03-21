package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Work {

    List<Student> students = new ArrayList<>();
    HashSet<Project> projects = new HashSet<>();

    public boolean AddStudents(Student student)
    {
        students.add(student);
        return true;
    }
    public void AddProject(Project project)
    {
        projects.add(project);
    }

    public void DisplayLowerThanAverageStudents()
    {
        float avg=0;
        for(int i=0;i< students.size();++i)
        {
            avg = avg + students.get(i).NumberOfPreferences();
        }
        avg = avg/ students.size();

        float finalAvg = avg;
        students.stream()
                .filter(x -> x.NumberOfPreferences() < finalAvg)
                .forEach(x -> {
                    System.out.println(x.GetName());
                });

    }

    public boolean Greedy()
    {
        Collections.sort(students);

        boolean isValid = true;
        for(int i=0;i< students.size();++i)
        {
            Project preference = students.get(i).GetFirstAvailableProject(projects);
            if(preference != null)
            {
                projects.remove(preference);
            }
            else {
                isValid = false;
            }
        }

        return isValid;
    }

}

