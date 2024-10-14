package main;

import java.util.Arrays;

class State {
    private int[][] bottles;
    
    public State(int[][] bottles) {
        this.bottles = Arrays.stream(bottles).map(int[]::clone).toArray(int[][]::new);
    }
    
    
    public int[][] getBottles() {
        return bottles;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State other = (State) obj;
        return Arrays.deepEquals(bottles, other.bottles);
    }

    public int hashCode() {
        return Arrays.deepHashCode(bottles);
    }
}
