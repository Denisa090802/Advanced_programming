package lab7.compulsory;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Gavrila Denisa
 */
public class Map {
    private static Location[][] matrix;

    public static void setupMap(int n) {
        matrix = new Location[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new Location[n];
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = new Location();
            }
        }
    }

    public static boolean exploreRandom(Robot robot) {
        for(var pair : getAvailablePositions(robot.getxPos(), robot.getyPos()))
        {
            synchronized (matrix[pair.getValue0()][pair.getValue1()]) {
                int row = pair.getValue0();
                int col = pair.getValue1();
                if(!matrix[row][col].isVisited())
                {
                    System.out.println(robot.getName() + " visited {" + pair.getValue0() + ", "+pair.getValue1()+" }");
                    matrix[row][col].visit();
                    matrix[row][col].getTokens().addAll(SharedMemory.extractTokens(matrix.length));
                    robot.getTokens().addAll(matrix[row][col].getTokens());
                    return true;
                }
            }
        }
        //System.out.println("NOWHERE TO GO :(");
        return false;
    }

    private static List<Pair<Integer, Integer>> getAvailablePositions(int row, int col)
    {
        List<Pair<Integer, Integer>> options = new ArrayList<>();
        for(int i = 0; i < 8; i++)
        {
            try{
                Pair<Integer, Integer> newLocation = generatePosition(i, row, col);
                if(newLocation.getValue0() < 0) continue;
                if(newLocation.getValue0() >= matrix.length) continue;

                if(newLocation.getValue1() < 0) continue;
                if(newLocation.getValue1() >= matrix.length) continue;

                options.add(newLocation);
            }
            catch (Exception e){}
        }
        Collections.shuffle(options);
        return options;
    }

    private static Pair<Integer, Integer> generatePosition(int i, int row, int col)
    {
        switch (i)
        {
            case 0:
                return new Pair<>(row + 1, col);
            case 1:
                return new Pair<>(row - 1, col);
            case 2:
                return new Pair<>(row, col + 1);
            case 3:
                return new Pair<>(row, col - 1);
            case 4:
                return new Pair<>(row + 1, col + 1);
            case 5:
                return new Pair<>(row - 1, col - 1);
            case 6:
                return new Pair<>(row + 1, col - 1);
            case 7:
                return new Pair<>(row - 1, col + 1);
        }
        return null;
    }
}
