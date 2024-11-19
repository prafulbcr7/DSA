package Java.trees.BinaryTree;

import Java.trees.BinaryTree.BinaryTree.Node;

public class Trees {
    private static Node root;

    public Trees(Node root){
        this.root = root;
    }

    public int getHeight(){
        return height(root);
    }

    private static int height(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right); 
        return 1 + Math.max(leftHeight,rightHeight);
    }


    public int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }

    public int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return root.val + left + right;
    }

    // Method to print the binary tree in a tree-like horizontal structure
    public static void printTree(Node root) {
        // Starting from the root, print the tree
        int height = height(root);
        printTree(root, 0, height, "H", 1);
    }

    // Recursive function to print the tree
    private static void printTree(Node node, int level, int height, String prefix, int branchType) {
        if (node != null) {
            // Print leading spaces to align the tree properly
            String spaces = " ".repeat((int) Math.pow(2, height - level - 1) - 1);
            // Print the node value with the proper spacing
            System.out.print(spaces + prefix + node.val);
            // Recursively print left and right children with adjusted prefix
            System.out.println();
            if (node.left != null || node.right != null) {
                printTree(node.left, level + 1, height, "L", 1);  // Left child
                printTree(node.right, level + 1, height, "R", 2); // Right child
            }
        }
    }


}
