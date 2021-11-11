package algo.ds.Graph;

import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    static class Node {
        int data;
        Node right;
        Node left;
        List<Node> neighbors;
    }

    public static void main(String[] args) {
        
    }


    public static boolean dfs(Node node, Set<Node> visited, int goal) {
        if(node == null) return false;
        if(node.data == goal) {
            return true;
        }
        for(Node neighbor : node.neighbors) {
            if(visited.contains(neighbor)) continue;
            visited.add(neighbor);
            boolean isFound = dfs(neighbor, visited, goal);
            if(isFound) {
                return true;
            }
        }
        return false;
    }
    
}
