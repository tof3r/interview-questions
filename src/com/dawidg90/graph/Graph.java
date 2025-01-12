package com.dawidg90.graph;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private final Map<Vertex, List<Vertex>> adjacentVertices;

    public Graph() {
        this.adjacentVertices = new LinkedHashMap<>();
    }

    void addVertex(String label) {
        adjacentVertices.putIfAbsent(new Vertex(label), new LinkedList<>());
    }

    void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        adjacentVertices.values().forEach(vertices -> vertices.remove(vertex));
        adjacentVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        adjacentVertices.get(vertex1).add(vertex2);
        adjacentVertices.get(vertex2).add(vertex1);
    }

    void removeEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        if (adjacentVertices.get(vertex1) != null) {
            adjacentVertices.get(vertex1).remove(vertex2);
        }
        if (adjacentVertices.get(vertex2) != null) {
            adjacentVertices.get(vertex2).remove(vertex1);
        }
    }

    Graph createGraph() {
        Graph graph = new Graph();

        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");

        graph.addVertex("Merry");
        graph.addVertex("Jerry");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        //introduce a cycle between Alice and Rob
//        graph.addEdge("Rob", "Alice");
//        graph.addEdge("Alice", "Rob");

        graph.addEdge("Merry", "Jerry");
        return graph;
    }

    List<Vertex> getAdjacentVerticesForVertex(String label) {
        return adjacentVertices.get(new Vertex(label));
    }

    Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjacentVerticesForVertex(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public void dfs(String start) {
        Set<String> isVisited = new LinkedHashSet<>();
        dfsRecursive(start, isVisited);
    }

    private void dfsRecursive(String current, Set<String> isVisited) {
        isVisited.add(current);
        System.out.print(current + " ");
        for (Vertex dest : adjacentVertices.get(new Vertex(current))) {
            if (!isVisited.contains(dest.label))
                dfsRecursive(dest.label, isVisited);
        }
    }

    Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjacentVerticesForVertex(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    private boolean hasPathDFSRecursive(Vertex source, Vertex destination, Set<String> visited) {
        visited.add(source.label);
        if (source.label.equals(destination.label)) return true;

        for (Vertex vertex : adjacentVertices.get(source)) {
            if (!visited.contains(vertex.label) && hasPathDFSRecursive(vertex, destination, visited)) return true;
        }

        return false;
    }

    public boolean hasPathDFS(String source, String destination, Set<String> visited) {
        return hasPathDFSRecursive(new Vertex(source), new Vertex(destination), visited);
    }

    public boolean hasPathBFS(String source, String destination, Set<String> visited) {
        return hasPathBFSIterative(new Vertex(source), new Vertex(destination), visited);
    }

    private boolean hasPathBFSIterative(Vertex source, Vertex destination, Set<String> visited) {
        Queue<String> visitedQueue = new LinkedList<>();
        visitedQueue.add(source.label);
        visited.add(source.label);

        while (!visitedQueue.isEmpty()) {
            String vertex = visitedQueue.poll();
            if (vertex.equals(destination.label)) return true;
            for (Vertex v : adjacentVertices.get(new Vertex(vertex))) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    visitedQueue.add(v.label);
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Vertex vertex : adjacentVertices.keySet()) {
            stringBuilder.append(vertex.label + "-> ");
            for (Vertex adjacent : adjacentVertices.get(vertex)) {
                stringBuilder.append(adjacent.label + ", ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int largestComponent(Set<String> visited) {
        return largestComponentAlg(visited);
    }

    private int largestComponentAlg(Set<String> visited) {
        var longestGraph = 0;
        for (Vertex v : adjacentVertices.keySet()) {
            var size = exploreGraphAndCount(v, visited);
            if (size > longestGraph) longestGraph = size;
        }
        return longestGraph;
    }

    private int exploreGraphAndCount(Vertex current, Set<String> visited) {
        if (visited.contains(current.label)) return 0;

        visited.add(current.label);

        var size = 1;
        for (Vertex v : adjacentVertices.get(current)) {
            size += exploreGraphAndCount(v, visited);
        }

        return size;
    }

    public int shortestPathFor(Vertex source, Vertex destination) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<AbstractMap.SimpleEntry<String, Integer>> visitedQueue = new LinkedList<>();
        visited.add(source.label);
        visitedQueue.add(new AbstractMap.SimpleEntry<>(source.label, 0));

        while (!visitedQueue.isEmpty()) {
            var vertex = visitedQueue.poll();
            var vertexLabel = vertex.getKey();
            var vertexDistance = vertex.getValue();
            if (vertexLabel.equals(destination.label)) return vertexDistance;
            for (Vertex v : adjacentVertices.get(new Vertex(vertexLabel))) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    visitedQueue.add(new AbstractMap.SimpleEntry<>(v.label, vertexDistance + 1));
                }
            }
        }
        //no path between verticies
        return -1;
    }

    public int islandCount(int[][] array) {
        int islandCounter = 0;
        Set<String> visited = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    if (exploreIsland(array, i, j, visited)) {
                        islandCounter++;
                    }
                }
            }
        }
        return islandCounter;
    }

    private boolean exploreIsland(int[][] array, int row, int column, Set<String> visited) {
        var rowInBounds = 0 <= row && row < array.length;
        var colInBounds = 0 <= column && column < array[0].length;
        if (!rowInBounds || !colInBounds) return false;
        if (array[row][column] == 0) return false;

        String visitedLocation = row + "," + column;
        if (visited.contains(visitedLocation)) return false;
        visited.add(visitedLocation);

        exploreIsland(array, row - 1, column, visited);//up
        exploreIsland(array, row + 1, column, visited);//down
        exploreIsland(array, row, column - 1, visited);//left
        exploreIsland(array, row, column + 1, visited);//right

        return true;//new island was explored
    }

    public int minimumIsland(int[][] array) {
        int islandCounter = Integer.MAX_VALUE;
        Set<String> visited = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    var islandSize = exploreIslandSize(array, i, j, visited);
                    if (islandSize > 0 && islandSize < islandCounter)
                        islandCounter = islandSize;
                }
            }
        }
        return islandCounter;
    }

    private int exploreIslandSize(int[][] array, int row, int column, Set<String> visited) {
        var rowInBounds = 0 <= row && row < array.length;
        var colInBounds = 0 <= column && column < array[0].length;
        if (!rowInBounds || !colInBounds) return 0;
        if (array[row][column] == 0) return 0;

        String visitedLocation = row + "," + column;
        if (visited.contains(visitedLocation)) return 0;
        visited.add(visitedLocation);

        int size = 1;

        size += exploreIslandSize(array, row - 1, column, visited);//up
        size += exploreIslandSize(array, row + 1, column, visited);//down
        size += exploreIslandSize(array, row, column - 1, visited);//left
        size += exploreIslandSize(array, row, column + 1, visited);//right

        return size;//new island was explored
    }

    public List<String> topologicalSort(String start) {
        LinkedList<String> result = new LinkedList<>();
        Set<String> isVisited = new LinkedHashSet<>();
        topologicalSortRecursive(new Vertex(start), isVisited, result);
        return result;
    }

    private void topologicalSortRecursive(Vertex current, Set<String> isVisited, LinkedList<String> result) {
        isVisited.add(current.label);
        for (Vertex dest : adjacentVertices.get(current)) {
            if (!isVisited.contains(dest.label))
                topologicalSortRecursive(dest, isVisited, result);
        }
        result.addFirst(current.label);
    }
}
