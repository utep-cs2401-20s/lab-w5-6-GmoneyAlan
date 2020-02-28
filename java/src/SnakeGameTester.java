import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {
    boolean[][] snake1 = {
            {false,false,false, false,false},
            {false,false,true,true,true},
            {false,false,true,false,true},
            {false,false,true,false,true},
            {false,false,true,true,true}
    };
    boolean[][] snake2 = {
            {true,false,true, false,false},
            {true,false,true,false,false},
            {true,true,true,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false}
    };
    boolean[][] snake3 = {
            {false,false,false,true},
            {false,false,false,true},
            {false,true,true,true},
    };
    boolean[][] snake4 = {
            {false,false,false,false},
            {false,false,false,false},
            {true,  true, true, true},
    };

    //Testing both Exhaustive and Recursive methods with snake 1
    //Snake 1 being the edge case for both methods where itll test what would happen if the user were to pass
    //a 2D array with the snake looping around
    // The starting head position will be at Row: 2 and Column: 2
    @Test
    public void testFindTailExhaustive1(){
        SnakeGame snake = new SnakeGame(snake1,2,1);
        snake.findTailExhaustive();
//        Expected output for head position will be {-1, -1,} and the length will be 10
//            since the code will not find a tail it'll go through the whole array without meeting the
//                the requirements for the given point to be considered a tail,
//                hence it'll stay its given value of -1 and -1.
//        The length of the snake will work since it just is counting values in the array that are considered true
        int[] test = {-1,-1,10};
        assertEquals(test ,snake.findTailExhaustive());
//      In this case the Exhaustive Checks will be equal to Row * columns, since there is no tail
        assertEquals(25, snake.getExhaustiveChecks());
    }
    @Test
    public void testFindTailRecursive1(){
        SnakeGame snake = new SnakeGame(snake1,2,1);
        snake.findTailRecursive();
//            Expected Output will be a stackoverflow error since this method's only stopping point is the tail, unlike
//            the exhaustive search
//                The reason for this error is the way the code is written it'll keep looping the snake ti'll it finds its
//                tail, which in this case will not happen
//                So thats why we get the error
    }
    //------------------------------------------------------------------------------------------------------------------


    //Testing both Exhaustive and Recursive methods with snake 2
    //Snake 2 will be used for the following:
//    If the exhaustive search will
//        -Get the right numbers of recursiveChecks
//        -Find the tail since it is right after the head
//     For the Recursive method will be checking if it will will follow through the snake even with the snakes
    @Test
    public void testFindTailExhaustive2(){
        SnakeGame snake = new SnakeGame(snake2, 0 , 0);
        snake.findTailExhaustive();
        int[] test = {0,2,7};
        assertEquals(test,snake.findTailExhaustive());
        //Since it is a nested loop it will go thru the first row where the tail is located thus 3
        assertEquals(3,snake.getExhaustiveChecks());
    }
    @Test
    public void testFindTailRecursive2(){
        SnakeGame snake = new SnakeGame(snake2, 0, 0);
        snake.findTailRecursive();
        int[] test = {0,2,7};
        assertEquals(test,snake.findTailRecursive());
        //The way the code is written recursive checks will always be the same as snake length
        assertEquals(7,snake.getRecursiveChecks());
    }
    //------------------------------------------------------------------------------------------------------------------


    //Testing both Exhaustive and Recursive methods with snake 3
    //Same principle as the board snake2 which will testing the snake turning but just a simpler version
    @Test
    public void testFindTailExhaustive3(){
        SnakeGame snake = new SnakeGame(snake3, 2, 1);
        snake.findTailExhaustive();
        int[] test = {0,3,5};
        assertEquals(test,snake.findTailExhaustive());
        //Tail is located in the first row and last column that's why the exhaustive checks is expected to be 4
        assertEquals(4,snake.getExhaustiveChecks());
    }
    @Test
    public void testFindTailRecursive3(){
        SnakeGame snake = new SnakeGame(snake3, 2, 1);
        snake.findTailRecursive();
        int[] test = {0,3,5};
        assertEquals(test,snake.findTailRecursive());
        //The way the code is written recursive checks will always be the same as snake length
        assertEquals(5,snake.getRecursiveChecks());
    }
    //------------------------------------------------------------------------------------------------------------------


    //Testing both Exhaustive and Recursive methods with snake 4
    //Testing a simple case were the snake is a straight line of length 4
    @Test
    public void testFindTailExhaustive4(){
        SnakeGame snake = new SnakeGame(snake4, 2, 0);
        snake.findTailExhaustive();
        int[] test = {2,3,4};
        assertEquals(test, snake.findTailExhaustive());
        //Exhaustive checks comes out to 12 since the tail is located at the last row and last column
        assertEquals(12,snake.getExhaustiveChecks());
    }
    @Test
    public void testFindTailRecursive4(){
        SnakeGame snake = new SnakeGame(snake4, 2, 0);
        snake.findTailRecursive();
        int[] test = {2,3,4};
        assertEquals(test, snake.findTailRecursive());
        //The way the code is written recursive checks will always be the same as snake length
        assertEquals(4,snake.getRecursiveChecks());
    }
    //------------------------------------------------------------------------------------------------------------------


    //Testing both Exhaustive and Recursive methods with default constructor
    //Where the gameboard is initialized to 1 Row && 1 Column
    //This only cell is also set to true, which means it is a snake of length 1
    @Test
    public void testFindTailExhaustive5(){
        SnakeGame snake = new SnakeGame();
        snake.findTailExhaustive();
        int[] test = {0,0,1};
        assertEquals(test, snake.findTailExhaustive());
        //Only able to check 1 cell, since the default game board is the following
        //Row: 1 && Column: 1
        assertEquals(1,snake.getExhaustiveChecks());
    }
    @Test
    public void testFindTailRecursive15(){
        SnakeGame snake = new SnakeGame();
        snake.findTailRecursive();
        int[] test = {0,0,1};
        assertEquals(test,snake.findTailRecursive());
        //The way the code is written recursive checks will always be the same as snake length
        assertEquals(1,snake.getRecursiveChecks());
    }

}
