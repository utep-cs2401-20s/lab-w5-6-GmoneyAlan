public class Main {
    public static void main(String[] args) {
        boolean[][] snake1 = {
                {false,false,false,false},
                {true,false,false,true},
                {true,false,false,true},
                {true,true, true, true}

        };
        SnakeGame snake = new SnakeGame(snake1, 1, 0);
        int[] alan = snake.findTailExhaustive();


        System.out.println("Row:" +alan[0] + " Column:"+ alan[1] + "  Length:" +alan[2]);

    }
}
