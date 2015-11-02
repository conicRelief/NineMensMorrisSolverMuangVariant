package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String s = "WxWxxxxxWWWxWWxBBBBxxxx";

        NMMBoardSerializer boardSerializer = new NMMBoardSerializer();
        String theString = "wxwxxxxxxbxxxxxxxxxxwxw";
        MorrisTernary[] board = boardSerializer.serializedInputStream(theString);
        for(Triable t: board)
        {print((Boolean) t.isNone());}



        StateSieves sieve = new StateSieves();
        PossibleStatesGenerator generator = new PossibleStatesGenerator();

        print(sieve.countBlack(board) + " black mills");
        print(sieve.countWhite(board) + " white mills");
        System.out.println(sieve.whitePeiceIsMovableHere(board, 1));

        List<Triable[]> item  = generator.midGameGenerateNextStates(board, true);
        print(item.size());

        List<Triable[]> newItem = new ArrayList<Triable[]>();
        newItem.addAll(item);

//        for(Triable[] t : item)
//        {
//            newItem.addAll(generator.openGameGenerateNextStates(t, false, 0, 0));
//        }


        for(Triable[] triable: newItem)
        {
            for(Triable t: triable)
            {
                if(t.isWhite())
                {
                    System.out.print("w");
                }
                else if (t.isBlack())
                {
                    System.out.print("b");
                }
                else
                {
                    System.out.print("x");
                }
            }
            System.out.print("|" + sieve.countBlack(triable) + " black Pieces left|" + sieve.countWhite(triable) + " white Pieces left|" + "\n");
        }

//        System.out.println(sieve.countNumberOfThreeInRowsWhite((Triable[]) board));
        //Generate n ply data objects in memory. This function would help us with whatever.
        // There should be a memory usage timeout such that the program doesn't crash.


        //Create the current board.
        // Turn into stateNode.

        // Genereate first best child for DFW frine
        // Generate all childs for DFW fringe
        // Iterative A* based generation
        // A* based generation
        //

    }
    public static void print(Object s)
    {
        System.out.println("Print Method Printing: " + s.toString());

    }

}
