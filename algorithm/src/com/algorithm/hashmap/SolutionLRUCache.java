package com.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * xiaOgang
 */
class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> entry = new HashMap<>();
    private int capacity, size;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = entry.get(key);
        if (node == null)
            return -1;
        moveToEnd(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = entry.get(key);
        if (node == null) {
            Node addNode = new Node(key, value);
            entry.put(key, addNode);
            size++;
            addToEnd(addNode);

            if (size > capacity) {
                removeHead();
                size--;
            }
        } else {
            node.value = value;
            moveToEnd(node);
        }
    }

    private void moveToEnd(Node node) {
        removeNode(node);
        addToEnd(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToEnd(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeHead() {
        Node node = head.next;
        removeNode(node);
        entry.remove(node.key);
    }
}

public class SolutionLRUCache {
    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
