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

        boolean[][] game = new boolean[sizer][sizec];

        headPosition = {x,y};

        for(int i = 0; i < g.length; i++){
            for(int j = 0; j <g.length; j++){
                game[i][j] = g[i][j];
            }
        }

    }

    public int[] findTailExhaustive(){
        int countEx = 0;



    }

}
