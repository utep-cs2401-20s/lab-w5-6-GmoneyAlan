public class Main {
    public static void main(String[] args) {
        boolean[][] snake1 = {
                {false,false,false, false,false},
                {false,false,true,true,true},
                {false,false,true,false,true},
                {false,false,true,false,true},
                {false,false,true,true,true}
        };
        boolean[][] snake2 = {
                {false,false,false, false,false},
                {false,false,false,false,false},
                {true,true,true,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false}
        };
        boolean[][] snake3 = {
                {true,false,true, false,false},
                {true,false,true,false,false},
                {true,true,true,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false}
        };
        boolean[][] snake4 = {
                {false,false,false,true},
                {false,false,false,true},
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

        SnakeGame snake = new SnakeGame(snake3, 0, 0); //not working with snake5 tPos is being overriden by 2,2

        int[] alan = snake.findTailExhaustive();
        System.out.println("Row:" +alan[0] + " Column:"+ alan[1] + "  Length:" +alan[2]);
        //System.out.println(SnakeGame.getRecursiveChecks());
        System.out.println("\nSame board now with recursive ");

        int[] alan2 = snake.findTailRecursive();
        System.out.println("Row:" +alan2[0] + " Column:"+ alan2[1] + "  Length:" +alan2[2]);
        System.out.println("Recursive checks: " + snake.getRecursiveChecks());

        SnakeGame snakeYEET = new SnakeGame();
        alan = snakeYEET.findTailExhaustive();
        System.out.println("Row:" +alan[0] + " Column:"+ alan[1] + "  Length:" +alan[2]);
        alan = snakeYEET.findTailRecursive();
        System.out.println("Row:" +alan[0] + " Column:"+ alan[1] + "  Length:" +alan[2]);
    }

}
