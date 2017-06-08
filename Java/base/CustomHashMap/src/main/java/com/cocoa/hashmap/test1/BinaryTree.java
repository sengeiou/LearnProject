package com.cocoa.hashmap.test1;


import java.util.ArrayList;
import java.util.List;

/**
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888/
 *
 *
 *
 *
 */
public class BinaryTree<T> {


    public static void main(String[] args) {
        BinaryTree<String> bt = new BinaryTree<String>();

        Node<String> C = new Node<String>(null, null, "C");
        Node<String> D = new Node<String>(null, null, "D");
        Node<String> B = new Node<String>(C, D, "B");


        Node<String> G = new Node<String>(null, null, "G");
        Node<String> F = new Node<String>(G, null, "F");
        Node<String> E = new Node<String>(null, F, "E");

        Node<String> root = new Node<String>(B, E, "r");

        bt.addRoot(root);
        // 这里只写了先序遍历，中序 和 后序 其实是一样的
        bt.preOrder(root);
        for (Node n : bt.list) {
            System.out.println(n.value);
        }

        System.out.println(bt.getSize(root));
        System.out.println(bt.getDeep(root));
    }


    private Node<T> root;

    public BinaryTree() {
        root = new Node<T>();
    }


    // 计算Node 的个数
    public int getSize(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return getSize(node.getPreNode()) + getSize(node.getNextNode()) + 1;
    }

    public int getDeep(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int left = getDeep(node.getPreNode());
        int right = getDeep(node.getNextNode());
        return left > right ? left +1 : right +1;
    }


    public void addRoot(Node<T> node) {
        root = node;
    }

    public List<Node> list = new ArrayList<>();

    // 前序遍历
    public void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.preNode);
        preOrder(node.nextNode);
    }


    public static class Node<T> {
        private Node<T> preNode;
        private Node<T> nextNode;
        private T value;

        public Node() {
        }

        public Node(Node<T> preNode, Node<T> nextNode, T value) {
            this.preNode = preNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        public void setPreNode(Node<T> preNode) {
            this.preNode = preNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPreNode() {
            return preNode;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public T getValue() {
            return value;
        }
    }
}