// https://leetcode.com/problems/lru-cache/

package Questions;

import java.util.HashMap;
import java.util.Map;

public class LRUCachee {

    class LRUCache {
        class Node{
            int key, value;
            Node next, back;

            Node() {}

            Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
        private void deleteNode(Node node){
            Node prev = node.back;
            Node front = node.next;
            prev.next = front;
            front.back = prev;
        }
        private void insertionAfterHead(Node node){
            Node start = head.next;
            node.next = start;
            node.back = head;
            head.next = node;
            start.back = node;
        }

        private Map<Integer, Node> map;
        private Node head, tail;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.back = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;

            Node nd = map.get(key);
            deleteNode(nd);
            insertionAfterHead(nd);
            return nd.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node nd = map.get(key);
                nd.value = value;
                deleteNode(nd);
                insertionAfterHead(nd);
            }
            else{
                if(map.size() == capacity){
                    Node node = tail.back;
                    map.remove(node.key);
                    deleteNode(node);
                }

                Node nd = new Node(key, value);
                insertionAfterHead(nd);
                map.put(key, nd);
            }
        }
    }

/**
 * Your LRUCachee object will be instantiated and called as such:
 * LRUCachee obj = new LRUCachee(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
