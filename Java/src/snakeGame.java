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

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks++;
        System.out.println("Check is at " + currentPosition[0] + currentPosition[1]);
        System.out.println("Current position is " + currentPosition[0] + currentPosition[1]);
        System.out.println("Previous position is " + previousPosition[0] + previousPosition[1]);
        int[] tailReturn = new int[3];
        int snakeLength = 0;
        int headX = headPosition[0];
        int headY = headPosition[1];
        int[] temp = {currentPosition[0],currentPosition[1]};


        if(currentPosition[0]-1 >= 0){
            if (this.game[currentPosition[0] - 1][currentPosition[1]] == true) {
                temp[0] = (currentPosition[0] - 1); //make different temporary array for neighbor
                temp[1] = (currentPosition[1]);
                if (temp[0] != previousPosition[0] || temp[1] != previousPosition[1]) {
                    snakeLength++;
                    return findTailRecursive(temp, currentPosition);
                }


                }
        }

        //public one returns what the private one gets
        //private is the one that is actually recursive
        //public is only 2 lines

        if (currentPosition[1] - 1 >= 0) {
            if (this.game[currentPosition[0]][currentPosition[1] - 1] == true) {
                temp[0] = (currentPosition[0]); //make different temporary array for neighbor
                temp[1] = (currentPosition[1] - 1);
                if (temp[0] != previousPosition[0] || temp[1] != previousPosition[1]) {
                    snakeLength++;
                    return findTailRecursive(temp, currentPosition);
                }
            }
        }

        if(currentPosition[1]+1< game[0].length) {
            if (this.game[currentPosition[0]][currentPosition[1] + 1] == true){
                temp[0] = (currentPosition[0]);
                temp[1] = (currentPosition[1] + 1);
            if (temp[0] != previousPosition[0] || temp[1] != previousPosition[1]) {
                snakeLength++;
                return findTailRecursive(temp, currentPosition);
            }
            }
        }
        if(currentPosition[0]+1 < game.length) {
            if (this.game[currentPosition[0] + 1][currentPosition[1]] == true) {
                temp[0] = (currentPosition[0] + 1);
                temp[1] = (currentPosition[1]);
                if (temp[0] != previousPosition[0] || temp[1] != previousPosition[1]) {
                    snakeLength++;
                    return findTailRecursive(temp , currentPosition);
                }
            }

        }

        if((neighbors(currentPosition[0],currentPosition[1]) == 1) && ((currentPosition[0] != headX) || (currentPosition[1] != headY))){
            tailReturn[0] = currentPosition[0];
            tailReturn[1] = currentPosition[1];
            tailReturn[2] = snakeLength;
            return tailReturn;
        }

        return tailReturn;
    }

    public int[] findTailRecursive(){
        resetCounters();
        return(findTailRecursive(headPosition,headPosition));
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
        for(int i = 0;  i < S.findTailRecursive().length; i ++){
            System.out.println(S.findTailRecursive()[i]);
        }
    }

}
