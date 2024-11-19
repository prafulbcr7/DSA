package Java.trees.BinaryTree;

import Java.trees.BinaryTree.BinaryTree.Node;

public class diameterOfATree {
    private int diameter;
    public int diameterOfBinaryTree(Node root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    private int longestPath(Node node){
        if(node == null) return 0;

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
