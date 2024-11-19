package Java.LinkedList;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    
    private int capacity;
    private Map<Integer, LinkedListNode> cacheMap;
    private LinkedList<LinkedListNode> lrulist;

    private class LinkedListNode {
        int key;
        int value;
        
        LinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        lrulist = new LinkedList<>();
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            LinkedListNode node = cacheMap.get(key);
            lrulist.remove(node);
            lrulist.addFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            LinkedListNode node = cacheMap.get(key);
            node.value = value;
            lrulist.remove(node);
            lrulist.addFirst(node);
        }
        else{
            if(capacity >= cacheMap.size()){
                LinkedListNode node = lrulist.removeLast();
                cacheMap.remove(node.key);
            }
            LinkedListNode node = new LinkedListNode(key, value);
            cacheMap.put(key, node);
            lrulist.addFirst(node);
        }
    }

}
