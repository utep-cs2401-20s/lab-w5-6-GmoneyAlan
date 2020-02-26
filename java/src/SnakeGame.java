public class SnakeGame {

    private boolean[][] game;;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks = 0;
    private static int recursiveChecks = 0;

    public SnakeGame(){
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] load, int row, int col){
        game = new boolean[load.length][load[0].length];
        for(int r = 0; r < load.length; r++){
            for(int c = 0; c < load[r].length; c++){
                game[r][c] = load[r][c];
            }
        }
        headPosition[0] = row;
        headPosition[1] = col;
    }

    public int[] findTailExhaustive(){
        int[] tPos = {-1,-1,0};
        resetCounters();
        for(int r = 0; r < game.length; r++){
            for(int c = 0; c < game[0].length; c++){
                if(game[r][c] && (vecinos(r,c) <= 1)){
                    if((r != headPosition[0]) || (c != headPosition[1])){
                        tPos[0] = r;
                        System.out.println(tPos[0]);
                        tPos[1] = c;
                        System.out.println(tPos[1]);
                    }
                }
                if(tPos[0] == -1 && tPos[1] == -1){
                    exhaustiveChecks++;
                }
                if(game[r][c]){
                    tPos[2]++;
                }
            }
        }
        return tPos;
    }//method end

    public int[] findTailRecursive(){
        resetCounters();
        int[] tPos = {-1,-1,0};
        return findTailRecursive(headPosition, tPos);
    }//method end

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] tPos = new int[3];
        if(headPosition[0] == currentPosition[0] && headPosition[1] == currentPosition[1]){
           previousPosition[2] = 1;
            return findTailRecursive(vecinosRecursive(currentPosition[0],currentPosition[1], currentPosition), previousPosition);

        }
        else if(vecinos(currentPosition[0],currentPosition[1] ) > 1){
            previousPosition[2]++;
            tPos[0] = previousPosition[0];
            tPos[1] = previousPosition[1];
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            return findTailRecursive(vecinosRecursive(currentPosition[0],currentPosition[1], currentPosition), previousPosition);
        }
        else
            previousPosition[2]++;
            tPos[2] = previousPosition[2];
            tPos[0] = currentPosition[0];
            tPos[1] = currentPosition[1];
            return tPos;

    }//method end

    public int[] vecinosRecursive(int r, int c, int[] previous){
        int newSpot[] = new int[2];
        if((r - 1> -1 && game[r - 1][c]) && (previous[0] != r && previous[1] == c)){
            newSpot[0] = r - 1;
            newSpot[1] = c;
        }//above
        else if((r + 1 < game.length && game[r + 1][c]) && (previous[0] != r&& previous[1] == c)){
            newSpot[0] = r + 1;
            newSpot[1] = c;
        }//below
        else if((c - 1 > -1 && game[r][c - 1]) && (previous[0] == r && previous[1] != c )){
            newSpot[0] = r;
            newSpot[1] = c - 1;
        }//left
        else if((c + 1 < game[r].length && game[r][c + 1]) && (previous[0] == r && previous[1] != c)){
            newSpot[0] = r;
            newSpot[1] = c + 1;
        }//right
        return newSpot;
    }
    public int vecinos(int r, int c){
        int sum = 0;
                if(r - 1> -1 && game[r - 1][c]){
                    sum++;
                }//above
                if(r + 1 < game.length && game[r + 1][c]){
                    sum++;
                }//below
                if(c - 1 > -1 && game[r][c - 1]){
                    sum++;
                }//left
                if(c + 1 < game[r].length && game[r][c + 1]){
                    sum++;
                }//right
        return sum;
    }
    private void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;
    }
    private static int getRecursiveChecks()
    {
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
