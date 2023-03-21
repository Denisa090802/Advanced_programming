package homework;

public class Main {

    public static void main(String[] args) {

        Work work = new Work();
        Student S1 = new Student();
        Student S2 = new Student();
        Student S3 = new Student();

        Project P1 = new Project();
        Project P2 = new Project();
        Project P3 = new Project();

        S1.addPreference(P1);
        S1.addPreference(P2);
        S1.addPreference(P3);
        S2.addPreference(P1);
        S2.addPreference(P2);
        S3.addPreference(P1);

        work.AddProject(P1);
        work.AddProject(P2);
        work.AddProject(P3);

        work.AddStudents(S1);
        work.AddStudents(S2);
        work.AddStudents(S3);

        work.DisplayLowerThanAverageStudents();
        System.out.println("----------------");
        if(work.Greedy())
            System.out.println("Can map");
        else
            System.out.println("Can not map :(");
    }
}
