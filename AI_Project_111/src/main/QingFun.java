package main;

import java.util.List;
import java.util.Queue;

public interface QingFun {
    Queue<Node> apply(Queue<Node> nodes, List<Node> expandedNodes);

}
