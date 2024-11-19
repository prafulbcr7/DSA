package Java.trees.BinaryTree;

public class Traversal {


    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1, 6,-1,-1}; // preOrder Sequence
        BinaryTree bt = new BinaryTree(nodes);
        System.out.print("PreOrder : ");
        bt.preOrder(bt.getRoot());
        System.out.println();

        System.out.print("InOrder : ");
        bt.inOrder(bt.getRoot());
        System.out.println();

        System.out.print("PostOrder : ");
        bt.postOrder(bt.getRoot());
        System.out.println();
        

        System.out.print("BFS - LevelOrder : \n");
        bt.levelOrder(bt.getRoot());
        System.out.println();

        Trees ht = new Trees(bt.getRoot());
        System.out.println("Height of Tree : " + ht.getHeight());
        System.out.println("Number of Nodes : " + ht.countNodes(bt.getRoot()));
        System.out.println("Sum of All Nodes : " + ht.sumOfNodes(bt.getRoot()));
        

        System.out.print("Top View of a Tree : \n");
        bt.topView(bt.getRoot());
        System.out.println();
    }

}