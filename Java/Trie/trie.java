package Java.Trie;

public class trie {
    
    private static Node root= new Node();

    public static class Node{
        Node[] children = new Node[26];
        boolean eow;

        Node(){
            for(int i=0; i<26;i++){
                children[i] = null;
            }
        }
    }

    public static void insert(String word){ // TC : O(L) where L is the length of the word
        Node curr = root;
        for(int level = 0; level< word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                // new Node
                curr.children[idx] = new Node();
            }
            else{
                // exisitng Node
                curr = curr.children[idx];
            }
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                System.out.println("Logs : Key not found");
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        String str = "the";
        if(search(str)){
            System.out.println("Word found");
        }
        else{
            System.out.println("Word not found");
        }
    }
}
