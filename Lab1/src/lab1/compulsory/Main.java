package lab1.compulsory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n*3;
        n=n+Integer.parseInt("10101", 2);
        n=n+Integer.parseInt("FF", 16);
        n=n*6;
        while(n>9)
        {
            n=sum_cif(n);
        }
        int result=n;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }

    static int sum_cif(int nr)
    {
        int s=0;
        while(nr!=0)
        {
            s=s+nr%10;
            nr=nr/10;
        }
        return s;
    }


}