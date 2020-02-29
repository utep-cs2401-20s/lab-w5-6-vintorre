import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class snakeGameTest {

    @Test
    public void findTailEx1() {
        boolean[][] test = {{true, true, true, false},
                {true, false, true, false},
                {true, false, true, false},
                {true, false, true, false}};
        int[] expected = {3, 2, 9};
        snakeGame test1 = new snakeGame(test, 3, 0);
        assertArrayEquals(expected, test1.findTailExhaustive());

        //chose this test case because I wanted to see what would happen when the head and the tail both shared the same either x or y
        //passed


    }

    @Test
    public void findTailEx2() {
        boolean[][] test2 = {{true, true, true},
                {false, false, true},
                {false, false, true},
                };
        int[] expected = {2, 2, 5};
        snakeGame test1 = new snakeGame(test2, 0, 0);
        assertArrayEquals(expected, test1.findTailExhaustive());

        //chose this test case to check if it would still count the snake, and return the right tail location when it was on the edge
        //passed

    }

    @Test
    public void findTailEx3() {
        boolean[][] test3 = {{true, true, true},
                {false, false, true},
                {false, false, true},
        };
        int[] expected = {0, 0, 5};
        snakeGame test1 = new snakeGame(test3, 2, 2);
        assertArrayEquals(expected, test1.findTailExhaustive());

        //chose this test case to see if my code would still count the snake even though the tail was found on the first check
        //passed


    }

    @Test
    public void findTailEx4() {
        boolean[][] test4 = {{true, true, true},
                {false, false, true},
                {false, false, true}};

        int[] expected = {0, 0, 5};
        int expectedint = 9;
        snakeGame test1 = new snakeGame(test4, 2, 2);
        test1.findTailExhaustive();
        assertEquals(expectedint, test1.getExhaustiveChecks());

        //wanted to see if my checks counter would still work even though it was the first block i checked
        //passed


    }

    @Test
    public void findTailEx5() {
        boolean[][] test5 = {{true, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}};

        int[] expected = {0, 0, 5};
        int expectedint = 16;
        snakeGame test1 = new snakeGame(test5, 2, 2);
        test1.findTailExhaustive();
        assertEquals(expectedint, test1.getExhaustiveChecks());

        //wanted to see if my checks counter would still work even though it was the first block i checked and i had no other blocks
        //passed


    }



    @Test
    public void findTailRe1() {
        boolean[][] test0 = {{true, true, true, false},
                {true, false, true, false},
                {true, false, true, false},
                {true, false, true, false}};
        int[] expected = {3, 2, 9};
        snakeGame test = new snakeGame(test0, 3, 0);
        assertArrayEquals(expected, test.findTailRecursive());


        //chose this test to make sure the result i got in findTailExaustive and recursive were the same


    }



}