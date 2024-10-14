package main;

class Node {
    State state;
    Node parent;
    Operator action;
    int pathCost;

    public Node(State state, Node parent, Operator action, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }
}

