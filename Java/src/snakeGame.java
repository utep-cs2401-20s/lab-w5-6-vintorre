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



        this.game = new boolean[sizer][sizec];
        this.headPosition = new int[2];

        headPosition[0] = x;
        headPosition[1] = y;

        for(int i = 0; i < g.length; i++){
            for(int j = 0; j <g[0].length; j++){
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
        int snakeLength = 0;
        int tailX = 0;
        int tailY = 0;
        int[] tailReturn = new int[3];

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                if(game[i][j] == true) {
                    snakeLength++;
                    if((neighbors(i,j) == 1) && ((i != headPosition[0]) || (j != headPosition[1]))){
                        tailX = i;
                        tailY = j;


                    }
                    if(neighbors(i, j) == 2)
                        continue;

                }

            }
        }

        tailReturn[0] = tailX;
        tailReturn[1] = tailY;
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

    public int[] findTailRecursive(){
        resetCounters();
        int[] tailReturn = new int[3];
        int tailX;
        int tailY;
        int snakeLength = 0;
        int headX = headPosition[0];
        int headY = headPosition[1];
        int[] currentPosition = {headPosition[0], headPosition[1]};
        int[] previousPosition = {headPosition[0], headPosition[1]};

        if(headX-1 >= 0){
            if (this.game[headX - 1][headY] == true)
                snakeLength++;
                currentPosition[0] = (headX - 1);
                currentPosition[1] = (headY);
                if(currentPosition[0] != previousPosition[0] || currentPosition[1] != previousPosition[1]) {
                    findTailRecursive();
                }
        }

        if (headY - 1 >= 0)
            if (this.game[headX][headY - 1] == true)
                snakeLength++;

        if(headY+1< game[0].length)
            if (this.game[headX][headY + 1] == true)
                snakeLength++;

        if(headX+1 < game.length) {
            if (this.game[headX + 1][headY] == true)
                snakeLength++;
        }


        return tailReturn;
    }

    public static int getRecursiveChecks(){
        return recursiveChecks;
    }

    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

    public static void main(String[] args) {
        boolean[][] test = {{true, true, true, false},
                            {true, false, true, false},
                            {true, false, true, false},
                            {true, false, true, false}};

        snakeGame S = new snakeGame(test, 3, 0);
        for(int i = 0;  i < S.findTailExhaustive().length; i ++){
            System.out.println(S.findTailExhaustive()[i]);
        }
    }

}
