package main;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class GenericSearch {
	public Node generalSearch(Problem problem, QingFun qingFun) {
        Queue<Node> nodes = makeQueue(makeNode(problem.initState()));

        while (!nodes.isEmpty()) {
            Node node = nodes.poll(); 
            if (goalTest(problem, node.state)) {
                return node; 
            }

        }
        return null; 
    }

    public Queue<Node> makeQueue(Node initialNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(initialNode);
        return queue;
    }

    public Node makeNode(State initialState) {
        return new Node(initialState, null, null, 0);
    }

    public boolean goalTest(Problem problem, State state) {
        return problem.isGoal(state);
    }

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