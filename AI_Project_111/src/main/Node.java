package main;

class Node {
    State state;      // Current state of the problem
    Node parent;      // Parent node
    Operator action;  // The action that generated this node
    int pathCost;     // The path cost to reach this node

    public Node(State state, Node parent, Operator action, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }
}

