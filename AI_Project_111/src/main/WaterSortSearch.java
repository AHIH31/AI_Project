package main;

import java.util.*;

public class WaterSortSearch extends GenericSearch {
    
    public String solve(String initialState, String strategy, boolean visualize) {
        Problem problem = new Problem(initialState); 
        Queue<Node> frontier = selectStrategy(strategy);  
        Node solutionNode = generalSearch(problem, frontier); 

        if (solutionNode == null) {
            return "NOSOLUTION";
        } else {
            String plan = solutionNode.getPathFromRoot();  
            int pathCost = solutionNode.getPathCost();  
            int nodesExpanded = frontier.size(); 
            
            if (visualize) {
                visualizeSolution(solutionNode);
            }

            return plan + ";" + pathCost + ";" + nodesExpanded;
        }
    }

    private Queue<Node> selectStrategy(String strategy) {
        switch (strategy) {
            case "BF":  // Breadth-First Search
                return  null;
            case "DF":  // Depth-First Search
                return null;
            case "UC":  // Uniform-Cost Search
                return null;
            // Add more strategies as needed (ID, GRi, ASi)
            default:
                throw new IllegalArgumentException("Unknown strategy: " + strategy);
        }
    }

    private void visualizeSolution(Node node) {
        Node current = node;
        List<String> solutionPath = new ArrayList<>();

        while (current.getParent() != null) {
            solutionPath.add(current.getState());
            current = current.getParent();
        }

        Collections.reverse(solutionPath);

        for (String state : solutionPath) {
            System.out.println(state);
        }
    }
}
