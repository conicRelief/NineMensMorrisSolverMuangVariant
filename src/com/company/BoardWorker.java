package com.company;

import java.util.*;

/**
 * Created by otto on 10/24/15.
 */
public class BoardWorker {

    StateNode root;
    public void loadRootState(StateNode s)
    {
//        StateNode root = new StateNode(s);
    }
public Triable[] computeViaMinMax(int ply, StateNode startNode)
{
    return null;
}
    public StateNode minMax(StateNode s)
    {

        return null;
    }



public List<Heuristic> generateAListOfHeuristics()
{
    List<Heuristic> heuristics =  new ArrayList<Heuristic>();

    final Heuristic killCount;
    final Heuristic meanKillCountDelta;

    killCount = new Heuristic() {
        @Override
        double generateHeuristic(Triable[] t) {
            double sum = 0.0;
            for(Triable boardLocation : t)
            {
                if(!boardLocation.isNone())
                {
                    if(boardLocation.isWhite())
                    {
                        sum+= 1;
                    }
                    else
                    {
                        sum-= 1;
                    }
                }
            }
            return sum;
        }
    };

    // Mean Count delta. You're supposed to give me some sort of gradient to help me search the gamestate tree. Its a
    // Heuristic I invented to help account for sub-optimal moves.
    // For now, you do nothing. Hang tight MeanKillCountDelta. Ill be back before you know it.

    meanKillCountDelta = new Heuristic() {
        @Override
        double generateHeuristic(Triable[] t) {
            return 0;
        }
    };

    /* meanKillCountDelta = new Heuristic() {
        // This heuristic generates a 2 ply expansion of a state tree. It then runs the kill-count heuristic on
        // The leaves and averages them together. This is takes into account wether or not sub-optimal choices are
        // made by the opponent.
        static final int MAXPLY = 2;
        double nodes_visited = 0;


        List<Triable[]> Fringe = new ArrayList<Triable[]>();
        @Override
        double generateHeuristic(Triable[] t) {
            //TODO: Implement this wierd Heuristic. Until then returning 0 should ensure that this Heuristic behaves like it doens't exist.


            return 0;
        }
        public double recursiveDepthThing(Triable[] t, int depth, boolean whiteTurn)
        {

            if(depth >= MAXPLY)
            {
                return killCount.generateHeuristic(t);
            }
            else
            {
                int sum = 0;
                for(int i = 0; i < t.length ; i++)
                {
                    if(t[i].isNone())
                    {
                        Triable[] newTri = t.clone();
                        if(whiteTurn)
                        {
                            sum += recursiveDepthThing(newTri, depth + 1, false);
                            nodes_visited ++;
                        }
                        if(whiteTurn)
                        {
                            sum += recursiveDepthThing(newTri, depth + 1, true);
                            nodes_visited ++;
                        }
                    }
                }
                return sum/nodes_visited;
            }
        }
    };

    */


    heuristics.add(killCount);
    heuristics.add(meanKillCountDelta);

    return heuristics;
}

}
