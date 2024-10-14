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
        // Define goal state check
        return state.equals(goalState); // Adjust as needed
    }

    public List<Operator> operators() {
        return operators;
    }
}

