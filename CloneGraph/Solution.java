package CloneGraph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode newNode = null;
        if (node != null && map.containsKey(node)) {
            newNode = map.get(node);
        } else if (node != null) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
            for (UndirectedGraphNode n : node.neighbors) {
                newNode.neighbors.add(cloneGraph(n));
            }
        }
        return newNode;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

}