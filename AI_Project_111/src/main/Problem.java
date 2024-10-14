	package main;

import java.util.List;

class Problem {
    State initialState;
    State goalState;
    List<Operator> operators;

    public Problem(State initialState, State goalState, List<Operator> operators) {
        this.initialState = initialState;
        this.goalState = goalState;
        this.operators = operators;
    }

    public State initState() {
        return initialState;
    }

    public boolean isGoal(State state) {
        return state.equals(goalState);
    }

    public List<Operator> operators() {
        return operators;
    }
}

