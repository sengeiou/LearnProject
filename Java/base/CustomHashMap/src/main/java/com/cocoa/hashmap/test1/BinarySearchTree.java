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
 *
 * 则左子树上所有结点的值均小于或等于它的根结点的值；
 * 若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 * 3 ： 每个节点包括一个键和值 （K V）
 * 4 :  节点可以为 null 或指向别的节点
 * 5 ： 如果一个根节点没有左子树，则根节点的key就是这个二叉树的最小值，如果存在左子树，那么最小值就是左子树的左子节点 ，见方法 min
 * 6 ： 如果一个根节点没有右子树，则根节点的key就是这个二叉树的最大值，如果存在右子树，那么最大值就是左子树的右子节点 ，见方法 max
 *
 *
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        bst.put(5, "5");
        bst.put(1, "1");
        bst.put(2, "2");
        bst.put(3, "3");
        bst.put(4, "4");
        bst.put(5, "57");
        bst.put(1, "1");


        System.out.println(bst.get(5));
        System.out.println(bst.get(2));


        System.out.println(bst.min());
        System.out.println(bst.max());


    }

    private Node<K, V> root;

    // 最小值
    public Node min(){
        return  min(root);
    }
    public Node min(Node node){
        if(node.getLeft()==null){
            return node;
        }
        return min(node.getLeft());
    }

    // 最大值
    public Node max(){
        return  max(root);
    }
    public Node max(Node node){
        if(node.getRight()==null){
            return node;
        }
        return max(node.getRight());
    }



    // 搜索方法
    public V get(K key) {
        return get(root, key);
    }


    public V get(Node<K, V> node, K key) {
        int t = key.compareTo(node.getKey());
        if (t == 0) {
            return node.getValue();
        } else if (t < 0) {
            return get(node.getLeft(), key);
        } else if (t > 0) {
            return get(node.getRight(), key);
        }
        return null;
    }


    // 插入方法
    public void put(K key, V value) {
        if (root == null) {
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

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node<K, V> getRight() {
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


        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", n=" + n +
                    '}';
        }
    }


}
