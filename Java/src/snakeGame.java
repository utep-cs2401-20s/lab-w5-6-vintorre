public class snakeGame {
    //recursion stop when I find the tail or when there is nothing else to look for
    //call on neighbors/ head
    //first is cells checked second is cells checked also

    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public snakeGame(){
        boolean[][] game = new boolean[1][1];
    }

    public snakeGame(boolean[][] g, int x, int y){
        int sizer = g.length;
        int sizec = g[0].length;

        game = new boolean[sizer][sizec];

        headPosition = new int[2];

        headPosition[0] = x;
        headPosition[1] = y;

        for(int i = 0; i < g.length; i++){
            for(int j = 0; j <g.length; j++){
                game[i][j] = g[i][j];
            }
        }

    }

    public void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int countEx = 0;
        int snakeLength = 0;
        int [] tailPosition = new int[2];
        int[] tailReturn = new int[3];

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                countEx++;
                if(game[i][j] == false)
                    continue;
                if(game[i][j] == true) {
                    snakeLength++;
                    if((neighbors(i,j) == 1) && (i != headPosition[0]) && (j != headPosition[1])) {
                        tailPosition[0] = i;
                        tailPosition[1] = j;
                    }
                    if(neighbors(i, j) == 2)
                        continue;

                }

            }
        }

        tailReturn[0] = tailPosition[0];
        tailReturn[1] = tailPosition[1];
        tailReturn[2] = snakeLength;
        return tailReturn;


    }

    public int neighbors(int r, int c){
        int count = 0;

        if(r-1 >= 0){
            if (this.game[r - 1][c] == true)
                count++;
        }

        if (c - 1 >= 0)
            if (this.game[r][c - 1] == true)
                count++;

        if(c+1< game[0].length)
            if (this.game[r][c + 1] == true)
                count++;

        if(r+1 < game.length) {
            if (this.game[r + 1][c] == true)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        boolean[][] test = {{true, true, true, false},{true, false, true, false},{true, false, true, false},{true, false, true, false}};

        snakeGame S = new snakeGame(test, 3, 0);
        System.out.println(S.findTailExhaustive());
    }

}
