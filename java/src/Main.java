import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean[][] snake1 = {
                {false,false,false, false,false},
                {false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false}
        };
        boolean[][] snake2 = {
                {false,false,false, false,false},
                {false,false,false,false,false},
                {true,true,true,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false}
        };
        boolean[][] snake3 = {
                {false,false,true, false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false}
        };
        boolean[][] snake4 = {
                {false,false,false,false},
                {false,false,false,false},
                {false,true,true,true},
        };
        boolean[][] snake5 = {
                {false,false,false,false},
                {false,false,false,false},
                {true,  true, true, true},
        };
        boolean[][] snake6 = {
                {true,false,false},
                {true,false,false},
                {true,false,false},
                {true,false,false}
        };

        SnakeGame snake = new SnakeGame(snake5, 2, 3); //not working with snake5 tPos is being overriden by 2,2
        int[] alan = Arrays.copyOf(snake.findTailExhaustive(),3);
        System.out.println("Row:" +alan[0] + " Column:"+ alan[1] + "  Length:" +alan[2]);
        //System.out.println(SnakeGame.getRecursiveChecks());
        System.out.println("Same board now with recursive \n");
        int[] alan2 = snake.findTailRecursive();
        System.out.println("Row:" +alan2[0] + " Column:"+ alan2[1] + "  Length:" +alan2[2]);
    }
}
