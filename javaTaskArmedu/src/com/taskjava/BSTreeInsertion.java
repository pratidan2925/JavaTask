//Steps:
//1. Create a Node class with left, right node references and data field
//
//2. Create BSTree class 
//    - Root node reference
//    - Insert node method
//        - Check if tree is empty, make new node as root
//        - Else traverse to correct spot and make new node left or right child following BST rules  
//
//3. Main method
//    - Create BSTree object
//    - Insert nodes sequentially with data as [5, 3, 8, 2, 4, 11]
//    - Print node data in order of insertion
//
//Expected Output: 
//5
//3
//8
//2
//4 
//11



package com.taskjava;

class Node {
    int data;
    Node left, right;
	public int distance;
	public int heuristic;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BSTree {
    Node root;

    BSTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);
        }
    }
}

public class BSTreeInsertion {
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        int[] dataList = { 5, 3, 8, 2, 4, 11 };

        for (int data : dataList) {
            bst.insert(data);
        }
System.out.println("The node data in order of insertion :");
        bst.printInOrder(bst.root);
    }
}



