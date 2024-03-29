/*
 * Author: Chanon Buathan
 * ID: 623040421-0
 * Sec: 1
 * Date: March 14, 2021
 */

package buathan.chanon.lab7;

import buathan.chanon.lab5.GuessNumberGameVer3;

import java.util.ArrayList;
import java.util.Collections;

public class GuessNumberGameVer4 extends GuessNumberGameVer3
{
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>(0);

    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries)
    {
        super(minNum, maxNum, maxTries);
    }

    public static void initGamesList()
    {
        games.add(new GuessNumberGameVer4(1, 10, 3));
        games.add(new GuessNumberGameVer4(1, 10, 5));
        games.add(new GuessNumberGameVer4(1, 5, 5));

        System.out.println("Unsorted");
        for (GuessNumberGameVer4 game: games)
        {
            System.out.println(game);
        }
    }

    public static void testComparingMaxTries()
    {
        initGamesList();
        Collections.sort(games, new SortByMaxTries());

        System.out.println("\nSorted by max tries in descending order");
        for (GuessNumberGameVer4 game: games)
        {
            System.out.println(game);
        }
    }


    public static void testComparingMaxTriesThenRandomRange()
    {
        initGamesList();
        Collections.sort(games, new SortByMaxTriesThenRandomRange());

        System.out.println("\nSorted by max tries in descending order " +
                "and random range in ascending order");
        for (GuessNumberGameVer4 game: games)
        {
            System.out.println(game);
        }
    }



    public static void main(String[] args)
    {
        //testComparingMaxTries();
        testComparingMaxTriesThenRandomRange();
    }
}
