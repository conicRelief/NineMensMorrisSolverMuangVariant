package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by otto on 10/26/15.
 */
public class StateSieves {

    // Used to gain information about the board.

    private List<int[]> listOfPosslibleMills = new ArrayList<int[]>();
    public HashMap<Integer, List<Integer[]>> positionToPossibleMillsMap;

    public StateSieves()
    {
        positionToPossibleMillsMap = new HashMap<Integer, List<Integer[]>>();
//        listOfPosslibleMills.add(new int[]{0, 1, 2});
//        listOfPosslibleMills.add(new int[]{0, 3, 6});
//        listOfPosslibleMills.add(new int[]{0, 8, 20});
//        listOfPosslibleMills.add(new int[]{2, 5, 7});
//        listOfPosslibleMills.add(new int[]{2, 13, 22});
//        listOfPosslibleMills.add(new int[]{3, 4, 5});
//        listOfPosslibleMills.add(new int[]{3, 9, 17});
//        listOfPosslibleMills.add(new int[]{5, 12, 19});
//        listOfPosslibleMills.add(new int[]{6, 10, 14});
//        listOfPosslibleMills.add(new int[]{7, 11, 16});
//        listOfPosslibleMills.add(new int[]{8, 9, 10});
//        listOfPosslibleMills.add(new int[]{11, 12, 13});
//        listOfPosslibleMills.add(new int[]{14, 15, 16});
//        listOfPosslibleMills.add(new int[]{15, 18, 21});
//        listOfPosslibleMills.add(new int[]{16, 19, 22});
//
//        listOfPosslibleMills.add(new int[]{17, 18, 19});
//        listOfPosslibleMills.add(new int[]{20, 21, 22});
//        listOfPosslibleMills.add(new int[]{20, 17, 14});

        listOfPosslibleMills.add(new int[]{0, 1, 2});
        listOfPosslibleMills.add(new int[]{0, 3, 6});
        listOfPosslibleMills.add(new int[]{0, 8, 20});

        listOfPosslibleMills.add(new int[]{2, 13,22});
        listOfPosslibleMills.add(new int[]{2, 5, 7});

        listOfPosslibleMills.add(new int[]{3, 4, 5});
        listOfPosslibleMills.add(new int[]{3, 9, 17});

        listOfPosslibleMills.add(new int[]{5, 12, 19});


        listOfPosslibleMills.add(new int[]{6, 10, 14});

        listOfPosslibleMills.add(new int[]{7, 11, 16});

        listOfPosslibleMills.add(new int[]{8, 9, 10});

        listOfPosslibleMills.add(new int[]{14, 15, 16});
        listOfPosslibleMills.add(new int[]{14, 17, 20});

        listOfPosslibleMills.add(new int[]{15, 18, 21});

        listOfPosslibleMills.add(new int[]{16, 19, 22});

        listOfPosslibleMills.add(new int[]{17, 18, 19});

        listOfPosslibleMills.add(new int[]{20, 21, 22});


        for(int x = 0 ; x<23; x++)
        {
            positionToPossibleMillsMap.put(x, new ArrayList<Integer[]>());
        }

        int x = 0;
        for(int[] possible : listOfPosslibleMills)
        {
            for(int i = 0 ; i<possible.length; i ++) {
                List<Integer[]> obj = positionToPossibleMillsMap.get(possible[i]);
                obj.add(intToIntegerTypeConverter(possible));
            }
        }



        for(Integer i : positionToPossibleMillsMap.keySet())
        {
            System.out.print(x + ":::");
            for(Integer[] j: positionToPossibleMillsMap.get(i))
            {
                System.out.print("|"+ j[0] + "," + j[1] + "," + j[2]+"|");
            }
            x++;
            System.out.print("\n");


        }
    }

    /**
     * Takes the board and a position K.  Returns a list of board positions that can be moved to fill K.
    **/
    public List<Integer> whitePeiceIsMovableHere(Triable[] morrisBoard, int location)
    {
        List<Integer> validPositionToMovePeiceFrom = new ArrayList<Integer>();
        // If there is something here. Then naturally you shouldn't be able to move to it.
        if(!morrisBoard[location].isNone())
        {return validPositionToMovePeiceFrom;}
        List<Integer[]> candidateSpots =  positionToPossibleMillsMap.get(location);

        for(Integer[] candidate: candidateSpots)
        {
            if(candidate[0] == location)
            {
                System.out.print("|cand0|");
                if(morrisBoard[candidate[1]].isWhite())
                {
                    validPositionToMovePeiceFrom.add(candidate[1]);
                }
            }
            else if(candidate[1] == location)
            {
                System.out.print("|cand1|");
                if(morrisBoard[candidate[0]].isWhite())
                {
                    validPositionToMovePeiceFrom.add(candidate[0]);
                }            }
                if( morrisBoard[candidate[2]].isWhite())
                {
                    validPositionToMovePeiceFrom.add(candidate[2]);
                }
            else if(candidate[2] == location)
            {
                System.out.print("|cand2|");
                if(morrisBoard[candidate[1]].isWhite())
                {
                    validPositionToMovePeiceFrom.add(candidate[1]);
                }
            }
        }


        return  validPositionToMovePeiceFrom;
    }

    public List<Integer> blackPeiceIsMovableHere(Triable[] morrisBoard, int location)
    {
        List<Integer> validPositionToMovePeiceFrom = new ArrayList<Integer>();
        // If there is something here. Then naturally you shouldn't be able to move to it.
        if(!morrisBoard[location].isNone())
        {return validPositionToMovePeiceFrom;}
        List<Integer[]> candidateSpots =  positionToPossibleMillsMap.get(location);

        for(Integer[] candidate: candidateSpots)
        {
            if(candidate[0] == location)
            {
                if(morrisBoard[candidate[1]].isBlack())
                {
                    validPositionToMovePeiceFrom.add(candidate[1]);
                }
            }
            else if(candidate[1] == location)
            {
                if(morrisBoard[candidate[0]].isBlack())
                {
                    validPositionToMovePeiceFrom.add(candidate[1]);
                }            }
            if( morrisBoard[candidate[2]].isBlack())
            {
                validPositionToMovePeiceFrom.add(candidate[2]);
            }
            else if(candidate[2] == location)
            {
                if(morrisBoard[candidate[1]].isBlack())
                {
                    validPositionToMovePeiceFrom.add(candidate[1]);
                }
            }
        }


        return  validPositionToMovePeiceFrom;
    }
    public int countNumberOfThreeInRowsWhite(Triable[] t)
    {
        int sumOfWhites = 0;

        for(int[] path: listOfPosslibleMills)
        {
            if(t[path[0]].isWhite() && t[path[1]].isWhite() && t[path[2]].isWhite())
            {
                 sumOfWhites++;
            }
        }
        return sumOfWhites;

    }
    public int countNumberOfThreeInRowsBlack(Triable[] t)
    {
        int sumOfBlacks = 0;
        for(int[] path: listOfPosslibleMills)
        {
            if(t[path[0]].isBlack() && t[path[1]].isBlack() && t[path[2]].isBlack())
            {
                sumOfBlacks++;
            }
        }
        return sumOfBlacks;
    }


    public boolean blackMillFormedOnBlackPlacement(Triable[] morrisBoard, int placement)
    {
        List<Integer[]> candidateSpots =  positionToPossibleMillsMap.get(placement);
        for(Integer[] candidate: candidateSpots)
        {
            if(candidate[0] == placement)
            {
                if(morrisBoard[candidate[1]].isBlack() && morrisBoard[candidate[2]].isBlack())
                {return  true;}
            }
            else if(candidate[1] == placement)
            {
                if(morrisBoard[candidate[0]].isBlack() && morrisBoard[candidate[2]].isBlack())
                {return  true;}            }
            else if(candidate[2] == placement)
            {
                if(morrisBoard[candidate[0]].isBlack() && morrisBoard[candidate[1]].isBlack())
                {return  true;}            }
        }

        return  false;
    }

    public boolean whiteMillFormedOnWhitePlaceMent(Triable[] morrisBoard, int placement)
    {
        List<Integer[]> candidateSpots =  positionToPossibleMillsMap.get(placement);
        for(Integer[] candidate: candidateSpots)
        {
            if(candidate[0] == placement)
            {
                if(morrisBoard[candidate[1]].isWhite() && morrisBoard[candidate[2]].isWhite())
                {return  true;}
            }
            else if(candidate[1] == placement)
            {
                if(morrisBoard[candidate[0]].isWhite() && morrisBoard[candidate[2]].isWhite())
                {return  true;}            }
            else if(candidate[2] == placement)
            {
                if(morrisBoard[candidate[0]].isWhite() && morrisBoard[candidate[1]].isWhite())
                {return  true;}            }
        }

        return  false;
    }

    public Integer[] intToIntegerTypeConverter(int[] original) {
        Integer[] newArray = new Integer[original.length];
        for (int i = 0; i < newArray.length; i++)
        {
           newArray[i] =   Integer.valueOf(original[i]);
        }
        return  newArray;
    }
    public int countBlack( Triable[] triables)
    {
        int sum = 0 ;
        for(Triable t : triables)
        {
            if (t.isBlack())
            {
                sum++;
            }
        }
        return  sum;
    }
    public int countWhite( Triable[] triable)
    {
        int sum = 0 ;
        for(Triable t : triable)
        {
            if (t.isWhite())
            {
                sum++;
            }
        }
        return  sum;
    }


}
