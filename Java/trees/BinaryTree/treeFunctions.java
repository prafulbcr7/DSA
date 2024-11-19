package Java.trees.BinaryTree;

import Java.trees.BinaryTree.BinaryTree.Node;

public class treeFunctions {
    
    public treeFunctions(){

        kthLevelOfBTPractice();
    }

    public static void kthLevelOfBTPractice(){
 
        // Tree Construction
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k=2;
        kthlevel(root, 0, k);
    }

    private static void kthlevel(Node root, int level, int k){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.val + " ");
            return;
        }

        kthlevel(root.left, level+1, k);
        kthlevel(root.right, level+1, k);
        return;
    }
}
