package main;
public class Node {
    private String state;
    private Node parent;
    private String operator;
    private int depth;
    private int pathCost;

    public Node(String state, Node parent, String operator, int depth, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.operator = operator;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    public String getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public String getOperator() {
        return operator;
    }

    public int getDepth() {
        return depth;
    }

    public int getPathCost() {
        return pathCost;
    }

    public String getPathFromRoot() {
        if (parent == null) {
            return operator == null ? "" : operator;  
        }
        return parent.getPathFromRoot() + " -> " + operator;
    }
}
