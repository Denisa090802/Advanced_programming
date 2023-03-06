package lab1.homework;

public class Main {

    static int[][] LatinSquare(int n)
    {
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; ++i)
            for(int j=0; j<n; ++j)
            {
                if( i==0 ) matrix[i][j] = j+1;
                else if(j==0) matrix[i][j]= matrix[i-1][n-1];
                else matrix[i][j] = matrix[i-1][j-1];
            }
        return matrix;
    }

    static void Lines(int n, int[][] m)
    {
        for(int i=0;i<n;++i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; ++j) {
            sb.append(m[i][j] + " ");
        }
        if(n<=10000) System.out.println(sb);
    }
    }

    static void Columns(int n, int[][] m){
        for(int j=0;j<n;++j) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(m[j][i]+ " ");
            }
            if(n<=10000) System.out.println(sb);
        }
    }

    public static void main (String[] args)
    {
        if(args.length!=1) {
            System.out.println("argumentul lipseste");
            return;
        }

        int n;
        try
        {
            n=Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("argument invlid");
            return;
        }
var m = LatinSquare(n);
long Start = System.currentTimeMillis();
Lines(n, m);
System.out.println();
Columns(n,m);
long End = System.currentTimeMillis();

if(n>10000) {
    System.out.println("Running time: " + (End - Start));
}

}}
