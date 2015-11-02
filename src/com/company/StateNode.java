package com.company;

import apple.laf.JRSUIConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by otto on 10/24/15.
 */
public class StateNode implements Comparable<StateNode>{

    static BoardWorker boardWorker = new BoardWorker();

    Short heuristicScore;
    public Triable[] theBoard;
    public Triable[] endStateMetaData; // This is data that we pass up all the way through min-max. Its a way of analyzing end game results.

        public List<StateNode> chilldren = new ArrayList<StateNode>();

    public StateNode(Triable[] t)
    {
        heuristicScore = calculateScore(t,0);
    }
    public short calculateScore(Triable[] triables  , Integer depth)
    {
        short sum = 0;
        for(Heuristic h : boardWorker.generateAListOfHeuristics())
        {
            sum+= ((Double) h.generateHeuristic(triables)).shortValue();
        }
        return sum;
    }

    @Override
    public int compareTo(StateNode stateNode) {
        return this.heuristicScore - stateNode.heuristicScore;
    }
}
