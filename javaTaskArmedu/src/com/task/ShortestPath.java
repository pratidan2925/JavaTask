package com.task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Node {
    String name;
    List<Edge> neighbors;
    int heuristic; // h(n)
    int distance;   // g(n)
    Node parent;

    public Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.heuristic = 0;
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
    }
}

class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class ShortestPath {

    public static List<Node> aStar(Node start, Node goal) {
        List<Node> openSet = new ArrayList<>();
        Set<Node> closedSet = new HashSet<>();

        start.distance = 0;
        start.heuristic = calculateHeuristic(start, goal);

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = getMinCostNode(openSet);
            openSet.remove(current);

            if (current == goal) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (Edge edge : current.neighbors) {
                Node neighbor = edge.target;

                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int tentativeDistance = current.distance + edge.weight;

                if (tentativeDistance < neighbor.distance) {
                    neighbor.parent = current;
                    neighbor.distance = tentativeDistance;
                    neighbor.heuristic = calculateHeuristic(neighbor, goal);

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null; // No path found
    }

    private static Node getMinCostNode(List<Node> nodes) {
        Node minNode = nodes.get(0);
        for (Node node : nodes) {
            if (node.distance + node.heuristic < minNode.distance + minNode.heuristic) {
                minNode = node;
            }
        }
        return minNode;
    }

    private static int calculateHeuristic(Node node, Node goal) {
        return Math.abs(node.name.charAt(0) - goal.name.charAt(0));
    }

    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.neighbors.add(new Edge(B, 3));
        B.neighbors.add(new Edge(C, 5));
        C.neighbors.add(new Edge(D, 7));
        D.neighbors.add(new Edge(A, 3));
        D.neighbors.add(new Edge(E, 10));

        Node start = A;
        Node goal = E;

        List<Node> path = aStar(start, goal);

        if (path != null) {
            System.out.println("Path: " + path.stream().map(node -> node.name).collect(Collectors.joining(" -> ")));
            System.out.println("Cost: " + path.get(path.size() - 1).distance);
        } else {
            System.out.println("No path found.");
        }
    }
}
