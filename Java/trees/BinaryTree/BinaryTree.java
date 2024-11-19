package Java.trees.BinaryTree;

import java.util.*;

public class BinaryTree {

    private Node root;
    private static int idx = -1;

    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    //Constructor
    public BinaryTree(int[] nodes){
        idx = -1;
        this.root = buildTree(nodes);
    }

    private Node buildTree(int[] nodes){
        idx++;
        if(idx == -1 || idx >= nodes.length || nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public Node getRoot(){
        return this.root;
    }


    public void preOrder(Node root){
        //Base Case
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                //print new line
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.val + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }


    // TOP VIEW OF A BINARY TREE
    static class Info{
        Node node;
        int hd;
        
        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    public void topView(Node root) {
        
        //base case
        if(root == null){
            return;
        }
        
        // add your code
        Queue<Info> q = new LinkedList<>();
        Map<Integer, Node> mp = new HashMap<>();
        
        int min=0, max=0;
        q.add(new Info(root,0));
        q.add(null);
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } 
                else{
                    q.add(null);
                }
            }
            else{
                // q is not null
                if(!mp.containsKey(curr.hd)){
                    mp.put(curr.hd, curr.node);
                }
                
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        
        for(int i=min; i<=max;i++){
            System.out.print(mp.get(i).val + " ");
        }
        System.out.println();
    }

}
