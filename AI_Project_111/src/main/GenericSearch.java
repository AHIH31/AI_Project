package main;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
public class GenericSearch {
	public Node generalSearch(Problem problem, QingFun qingFun) {
        // Initialize the queue with the initial node
        Queue<Node> nodes = makeQueue(makeNode(problem.initState()));

        while (!nodes.isEmpty()) {
            // Remove the front node of the queue
            Node node = nodes.poll(); 

            // If the goal is achieved, return the node
            if (goalTest(problem, node.state)) {
                return node; 
            }

            // Add expanded nodes back to the queue using the qing function
           // nodes = QingFun(nodes, expand(node, problem.operators()));
        }
        return null; // If the queue is empty, return failure (null)
    }

    // Function to create a queue with an initial node
    public Queue<Node> makeQueue(Node initialNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(initialNode);
        return queue;
    }

    // Function to create an initial node
    public Node makeNode(State initialState) {
        return new Node(initialState, null, null, 0);
    }

    // Function to test if the goal state is achieved
    public boolean goalTest(Problem problem, State state) {
        return problem.isGoal(state);
    }

    // Function to expand a node by applying all available operators
    public List<Node> expand(Node node, List<Operator> operators) {
        List<Node> expandedNodes = new LinkedList<>();
        for (Operator op : operators) {
            State newState = op.apply(node.state);
            Node newNode = new Node(newState, node, op, node.pathCost + op.cost());
            expandedNodes.add(newNode);
        }
        return expandedNodes;
    }
}