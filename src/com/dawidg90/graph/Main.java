package com.dawidg90.graph;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph = graph.createGraph();

        System.out.println(graph);

        Set<String> alice = graph.depthFirstTraversal(graph, "Alice");
        System.out.println("DFS for Alice: ");
        alice.forEach(s -> System.out.print(s + " "));

        System.out.println();

        System.out.println("Recursive DFS for Alice: ");
        graph.dfs("Alice");

        Set<String> bob = graph.breadthFirstTraversal(graph, "Bob");
        System.out.println("\nBFS for Bob: ");
        bob.forEach(s -> System.out.print(s + " "));

        System.out.println();

        boolean hasPath = graph.hasPathDFS("Alice", "Rob", new LinkedHashSet<>());
        System.out.println("[Recursive DFS] Has path from Alice to Rob: " + hasPath);
        boolean hasNoPath = graph.hasPathDFS("Alice", "George", new LinkedHashSet<>());
        System.out.println("[Recursive DFS] Has path from Alice to George: " + hasNoPath);

        boolean hasPathBFS = graph.hasPathBFS("Alice", "Rob", new LinkedHashSet<>());
        System.out.println("[Iterative BFS] Has path from Alice to Rob: " + hasPathBFS);
        boolean hasNoPathBFS = graph.hasPathBFS("Alice", "George", new LinkedHashSet<>());
        System.out.println("[Iterative DFS] Has path from Alice to George: " + hasNoPathBFS);

        int largestGraphSize = graph.largestComponent(new LinkedHashSet<>());
        System.out.println("The largest graph has size: " + largestGraphSize);

        int pathFor = graph.shortestPathFor(new Vertex("Bob"), new Vertex("Rob"));
        System.out.println("Shortest path from Bob to Rob: " + pathFor);

        int pathFor1 = graph.shortestPathFor(new Vertex("Alice"), new Vertex("Jerry"));
        System.out.println("Shortest path from Alice to Jerry (Jerry is in separate graph): " + pathFor1);

        List<String> stringList = graph.topologicalSort("Bob");
        System.out.println("Topological sort starting from Bob");
        stringList.forEach(s -> System.out.print(s + " "));

        int[][] islands = new int[][]{
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
        };

        System.out.println("\nIslands to count:");
        displayIsland(islands);

        int count = graph.islandCount(islands);
        System.out.println("Islands counted: " + count);

        int smallest = graph.minimumIsland(islands);
        System.out.println("Smallest island size on a map is: " + smallest);
    }

    public static void displayIsland(int[][] islands) {
        for (int[] island : islands) {
            for (int j = 0; j < islands.length; j++) {
                if (island[j] == 1) System.out.print("□");
                if (island[j] == 0) System.out.print("-");
            }
            System.out.println();
        }
    }
}
