package main;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

import java.util.*;

public class GenericSearch {
    
    public Node generalSearch(Problem problem, Queue<Node> nodes) {
        // Initialize the queue with the initial state
        nodes.add(makeNode(problem.initialState()));

        // Start the search loop
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();  // REMOVE-FRONT operation
            if (goalTest(problem, node.getState())) {
                return node;  // Solution found
            }
            nodes.addAll(expand(node, problem));  // Expand the node and add to the frontier
        }
        
        return null;  // No solution found
    }

    // Creates the initial node from the initial state
    protected Node makeNode(String initialState) {
        return new Node(initialState, null, null, 0, 0);  // Root node, no parent, operator, depth 0, path cost 0
    }

    // Checks if the given state is a goal state
    protected boolean goalTest(Problem problem, String state) {
        return problem.goalTest(state);
    }

    // Expands a node by generating child nodes based on possible actions
    protected List<Node> expand(Node node, Problem problem) {
        List<Node> successors = new ArrayList<>();
        List<String> operators = problem.getOperators(node.getState());

        for (String operator : operators) {
            String newState = problem.applyOperator(node.getState(), operator);  // Apply the operator to get the new state
            int newPathCost = node.getPathCost() + problem.getCost(operator);  // Increment the path cost
            Node childNode = new Node(newState, node, operator, node.getDepth() + 1, newPathCost);
            successors.add(childNode);
        }
        
        return successors;
    }
}
