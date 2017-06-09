public class BinaryTree<T> {

	/**
	二叉树又叫 BinaryTree , 二叉树的每个节点只能有两个子节点（左子节点 和 右子节点）
	二叉树有五种基本形态：
	1：空二叉树
	2：只有一个根节点
	3：只有左子树
	4：只有右子树
	5：完全二叉树

	类型分：
	1 完全二叉树     若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。

	2 满二叉树 full binary tree 除了叶结点外每一个结点都有左右子叶且叶子结点都处在最底层的二叉树。
	  满二叉树如果有N 层，那节点数就是 （2的N次方）-1 ，一定是个奇数  第I层的个数就是 2的（I-1）次方

	3 平衡二叉树

	性质:
	1、非空二叉树的第n层上至多有2^(n-1)个元素。
	2、深度为h的二叉树至多有2^h-1个结点。


	遍历即将树的所有结点访问且仅访问一次。按照根节点位置的不同分为前序遍历，中序遍历，后序遍历。
	前序遍历：根节点->左子树->右子树
	中序遍历：左子树->根节点->右子树
	后序遍历：左子树->右子树->根节点

	http://blog.csdn.net/luckyxiaoqiang/article/details/7518888/

	*/
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
        for(Node n : bt.list){
            System.out.println(n.value);
        }

		System.out.println(bt.getSize(root));

    }


    private Node<T> root;

    public BinaryTree() {
        root = new Node<T>();
    }

    public int getSize(Node<T> node){
    	if(node==null){
    		return 0;
    	}	
    	return 	getSize(node.getPreNode()) + getSize(node.getNextNode())+1;
    }


    public void addRoot(Node<T> node) {
        root = node;
    }
    public List<Node> list = new ArrayList<>();
    // 前序遍历
    public void preOrder(Node<T> node) {
        if(node==null){
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