public class SnakeGame {

    private boolean[][] game;;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(){
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] load, int x, int y){
        game = new boolean[load.length][load[0].length]
        for(int r = 0; r < load.length; r++){
            for(int c = 0; c < load[r].length; c++){
                game[r][c] = load[r][c];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        
    }//method end
    public int[] findTailRecursive(){

    }//method end
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

    }//method end

    public int snakebody(int r, int c){
        int sum = 0;

                if(r - 1> -1 && game[r - 1][c]){
                    sum++;
                }
                if(r + 1 < game.length && game[r + 1][c]){
                    sum++;
                }
                if(c - 1 > -1 && game[r][c - 1]){
                    sum++;
                }
                if(c + 1 < game[r].length && game[r + 1][c]){
                    sum++;
                }
        return sum;
    }
    private void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;
    }
    private static int getRecursiveChecks(){
        return recursiveChecks;
    }
    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

    public void printGame(){
        for(int r = 0; r < game.length; r++){
            for(int c = 0; c < game.length; c++){
                System.out.println(game[r][c] + " ");
            }
        }
    }

}//class
