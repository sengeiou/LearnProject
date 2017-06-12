package com.cocoa.hashmap.test1;

/**
 * 二叉排序树（Binary Sort Tree）又称二叉查找树（Binary Search Tree），亦称二叉搜索树。
 * http://baike.baidu.com/link?url=uhnp1bMyAufRNwqBWD8EI06VdKFO6y_D0NNriqT6VlXHsVqu5dh1r5xlpyhRqcp0bdDRbE-tm--R5UQP060OcQZ62eXrEEnjlLd1cm194THms7v1RGaQ44Or9wwZoxVP6HghF_6pxQpU391b4vx9W-U9Nz5hxH90fI371ytXdX6bHELrcB7KLQc_PKsiVjGfkSvTcKJsUk2Piq19DEZhyLPX1xKlTCHszYUIVTGGtgq
 * 百度百科的介绍，其中二叉查找树的搜索复杂度 ，要再看下
 * <p>
 * <p>
 * 特点:
 * 1 ： 每个节点只能有一个父节点，根节点除外，根节点没有父节点
 * 2 ： 每个节点都有两个子节点（左子节点 和 右子节点）若左子树不空，
 * 则左子树上所有结点的值均小于或等于它的根结点的值；
 * 若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 * 3 ： 每个节点包括一个键和值 （K V）
 * 4 :  节点可以为 null 或指向别的节点
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        bst.put(5, "5");
        bst.put(2, "2");
        bst.put(3, "3");
        bst.put(4, "4");
        bst.put(5, "57");
        bst.put(1, "1");
            

    }

    private Node root;




    // 插入方法
    public void put(K key, V value) {
        if(root == null){
            root = put(root, key, value);
        }
        put(root, key, value);
    }

    private Node put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int c = key.compareTo(node.getKey());
        if (c < 0) {
            //left  如果这里的node.left== null ，递归就会生成新的节点，然后node.setLeft 就放置了新的节点，
            node.setLeft(put(node.left, key, value));
        } else if (c > 0) {
            //right
            node.setRight(put(node.right, key, value));
        } else {
            node.setValue(value);
        }
        return node;
    }


    static class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int n;   //  子节点的个数

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }


}
