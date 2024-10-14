package main;

import java.util.Arrays;

class Operator {
    private int fromBottle;
    private int toBottle;

    public Operator(int fromBottle, int toBottle) {
        this.fromBottle = fromBottle;
        this.toBottle = toBottle;
    }

    // Apply the operator to a given state, returning a new state
    public State apply(State state) {
        int[][] newBottles = Arrays.stream(state.getBottles())
                                   .map(int[]::clone)
                                   .toArray(int[][]::new);

        // Perform the action: pour from `fromBottle` to `toBottle`
        pourLiquid(newBottles, fromBottle, toBottle);

        return new State(newBottles);
    }

    // A simple method to pour liquid between bottles (needs proper implementation)
    private void pourLiquid(int[][] bottles, int from, int to) {
        // Example of pouring liquid (logic should depend on the rules of your puzzle)
        // For simplicity, assume the topmost liquid in `from` is moved to `to`
        // Detailed logic should account for bottle fill levels, color matches, etc.
        // bottles[from] --> bottles[to]
    }

    // Cost of performing this operator (assume each pour has a uniform cost)
    public int cost() {
        return 1;
    }

    @Override
    public String toString() {
        return "Pour from bottle " + fromBottle + " to bottle " + toBottle;
    }
}

