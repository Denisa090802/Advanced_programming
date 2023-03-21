package homework;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Student implements Comparable<homework.Student>{

    List<Project> projectsList = new ArrayList<>();
    String name;

    /**
     * constructor
     * @param _name
     */
    public Student(String _name)
    {
        name = _name;
    }

    public Student()
    {
        Faker faker = new Faker();

        name = faker.name().fullName(); // Miss Samanta Schmidt
    }

    /**
     * returneaza numele studentului
     * @return
     */
    public String GetName()
    {
        return name;
    }

    public void addPreference(Project project)
    {
        projectsList.add(project);
    }
    public int NumberOfPreferences()
    {
        return projectsList.size();
    }

    /**
     * compara un student cu un altul
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(homework.Student o) {

        return Integer.compare(NumberOfPreferences(), o.NumberOfPreferences());
    }

    public homework.Project GetFirstAvailableProject(HashSet<homework.Project> projects)
    {
        for(int i=0;i<projectsList.size();++i)
        {
            if(projects.contains(projectsList.get(i)))
                return projectsList.get(i);
        }
        return null;
    }
}