package com.dawidg90.tree.binary;

public class Main {
    public static void main(String[] args) {
        SortedBinaryTree sortedBinaryTree = SortedBinaryTree.createTree();
        boolean containsNode = sortedBinaryTree.containsNode(6);
        System.out.println("Contains 6: " + containsNode);
        boolean containsNode1 = sortedBinaryTree.containsNode(1);
        System.out.println("Contains 1: " + containsNode1);

        System.out.println("Pre order traversal");
        sortedBinaryTree.traversePreOrder(sortedBinaryTree.root);

        System.out.println("\nIn order traversal");
        sortedBinaryTree.traverseInOrder(sortedBinaryTree.root);

        System.out.println("\nPost order traversal");
        sortedBinaryTree.traversePostOrder(sortedBinaryTree.root);

        System.out.println("\nBreadth first search");
        sortedBinaryTree.breadthFirstSearch();

        //Time complexity: O(n)
        //Space complexity: O(n)
        int treeHeight = sortedBinaryTree.treeHeight(sortedBinaryTree.root);
        System.out.println("\nHeight of the tree is: " + treeHeight);

        //Time complexity: O(n)
        //Space complexity: O(n)
        int leaves = sortedBinaryTree.countLeaves(sortedBinaryTree.root);
        System.out.println("Number of leaves are: " + leaves);

        boolean contains9 = sortedBinaryTree.containsNode(9);
        System.out.println("Tree contains 9: %s".formatted(contains9));
        if (contains9) {
            System.out.println("Deleting 9 from the tree");
            sortedBinaryTree.delete(9);
        }
        boolean contains9AfterDeletion = sortedBinaryTree.containsNode(9);
        System.out.println("Tree contains 9: %s".formatted(contains9AfterDeletion));
    }
}
