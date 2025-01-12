package com.dawidg90.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class SortedBinaryTree {
    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    public static SortedBinaryTree createTree(){
        SortedBinaryTree tree = new SortedBinaryTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        return tree;
    }

    private boolean containsRecursive(Node current, int value){
        if (current == null) {
            return false;
        }
        if(value == current.value) {
            return true;
        }
        return value < current.value
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    public boolean containsNode(int value){
        return containsRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null)
            return null;

        if (value == current.value) {
            //case 1: node is a leaf
            if (current.left == null && current.right == null) {
                return null;
            }
            //case 2: node has one child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            //case 3: node has two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root){
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public void traverseInOrder(Node node){
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    public void breadthFirstSearch(){
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(" " + node.value);

            if (node.left != null){
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    //Given a binary tree, find height of it.
    // Height of empty tree is -1, height of tree
    // with one node is 0;
    public int treeHeight(Node node){
        if (node == null) return -1;
        int leftDepth = treeHeight(node.left);
        int rightDepth = treeHeight(node.right);
        return Math.max((leftDepth+1), (rightDepth+1));
    }

    //Count leaf nodes in a binary tree
    public int countLeaves(Node node){
        return countLeavesRecursive(node);
    }

    private int countLeavesRecursive(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeavesRecursive(node.left) + countLeavesRecursive(node.right);
    }

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return areSymmetric(root.left, root.right);
    }

    private boolean areSymmetric(Node left, Node right) {
        if (left == null && right == null) return true;
        else if ((left == null) != (right == null) || left.value != right.value) return false;
        else return areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
    }
}
