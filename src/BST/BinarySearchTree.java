package BST;

import DynamicArray.Array;
import Queue.ArrayQueue;
import Queue.IQueue;
import Stack.ArrayStack;
import Stack.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class BinarySearchTree<E extends Comparable<E>> {

    private class Node{
        public E e;

        public Node left,right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
//        if(root==null){
//            size++;
//            root = new Node(e);
//        }
//        add(root,e);
        root = add(root,e);
    }

    private Node add(Node root, E e ){
//        if(e.equals(root.e)){
//            return;
//        }
//        else if(e.compareTo(root.e)>0 && root.right==null){
//            root.right = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(root.e)<0 && root.left==null){
//            root.left = new Node(e);
//            size++;
//            return;
//        }
//        if(e.compareTo(root.e)>0){
//            add(root.right,e);
//        }else{
//            add(root.left,e);
//        }
        if(root == null){
            size++;
            root = new Node(e);
            return root;
        }
        if(e.compareTo(root.e)<0){
           root.left =  add(root.left,e);
        }else if(e.compareTo(root.e)>0){
            root.right = add(root.right,e);
        }
        return root;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node root ,E e){
        if(root == null){
            return false;
        }
        if(e.compareTo(root.e)==0){
            return true;
        }
        else if(e.compareTo(root.e)>0){
            return contains(root.right,e);
        }else{
            return contains(root.left,e);
        }
    }

    public List preOrder(){
        List<E> es = new ArrayList<>();
        preOrder(root,es);
        return es;
    }

    private List preOrder(Node root,List nodes) {
        if(root!=null){
            nodes.add(root.e);
            preOrder(root.left,nodes);
            preOrder(root.right,nodes);
        }
        return nodes;
    }

    private Array preOrderNR(){
        Array<E> array = new Array<>();
        Stack<Node> stack = new ArrayStack<Node>();
        stack.push(root);
        while (!stack.isEmpEry()){
            Node cur = stack.pop();
            array.addLast(cur.e);
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
        }
        return array;
    }


    public List inOrder(){
        List<E> es = new ArrayList<>();
        inOrder(root,es);
        return es;
    }

    private List inOrder(Node root,List nodes) {
        if(root!=null){
            inOrder(root.left,nodes);
            nodes.add(root.e);
            inOrder(root.right,nodes);
        }
        return nodes;
    }

    public List postOrder(){
        List<E> es = new ArrayList<>();
        postOrder(root,es);
        return es;
    }

    private List postOrder(Node root,List nodes) {
        if(root!=null){
            postOrder(root.left,nodes);
            postOrder(root.right,nodes);
            nodes.add(root.e);
        }
        return nodes;
    }

    /**
     * 适用于搜索，层序遍历
     * @return
     */
    public Array levelOrder(){
        Array<E> array = new Array<>();
        IQueue<Node> queue = new ArrayQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()){
            Node node = queue.deQueue();
            array.addLast(node.e);
            if(node.left!=null){
                queue.enQueue(node.left);
            }
            if(node.right!=null){
                queue.enQueue(node.right);
            }
        }
        return array;
    }

    public Node maxItem(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxItem(root);
    }

    private Node maxItem(Node node){
        if(node.right==null)
            return node;
        return maxItem(node.right);
    }

    public Node minItem(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minItem(root);
    }

    private Node minItem(Node root) {
        if(root.left==null){
            return root;
        }
        return minItem(root.left);
    }


    /**
     * 自创删除
     * @return
     */
    public E removeMaxItemCustom(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return removeMaxItem(root).e;
    }

    private Node removeMaxItem(Node node) {
        if(node.right==null){
            if(node.left!=null){
                Node cur = queryMaxCurNode(root,node);
                cur.right = node.left;
                node.left = null;
            }
            return node;
        }
        return removeMaxItem(node.right);
    }

    private Node queryMaxCurNode(Node root,Node cur) {
        if(root.right==cur){
            size--;
            return root;
        }
        return queryMaxCurNode(root.right,cur);
    }

    /**
     * 老师的删除方法
     * @return
     */
    public E removeMin(){
        Node node = minItem();
        root = removeMin(root);
        return node.e;
    }

    private Node removeMin(Node root) {
        if(root.left==null){
            Node rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
    }

    /**
     * 老师的删除方法
     * @return
     */
    public E removeMax(){
        Node node = maxItem();
        root = removeMax(root);
        return node.e;
    }

    private Node removeMax(Node root) {
        if(root.right==null){
            Node rightNode = root.left;
            root.left = null;
            size--;
            return rightNode;
        }
        root.right = removeMax(root.right);
        return root;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }
        else{//e == node.e
            if(node.left==null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return  leftNode;
            }

            //左右子树不为空
            Node successor = minItem(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    private void generateBSTString(Node root, int i, StringBuilder sb) {
        if(root == null){
            sb.append(generateDepthString(i)+"null\n");
            return;
        }
        sb.append(generateDepthString(i)+root.e+"\n");
        generateBSTString(root.left,i+1,sb);
        generateBSTString(root.right,i+1,sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<depth; i++){
            sb.append("--");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
        BinarySearchTree<Integer> searchTree1 = new BinarySearchTree<>();
//        int[] nums = {12,23,32,32,32,323,2,3,300};
//        for (int num:nums) {
//            searchTree1.add(num);
//            searchTree.add(num);
//         }
        Random random = new Random();
        for(int i = 0; i<10000;i++){
            int i1 = random.nextInt(10000);
            searchTree.add(i1);
            searchTree1.add(i1);
        }
//        List prelist = searchTree.preOrder();
//        System.out.println(prelist);
//        Array array = searchTree.preOrderNR();
//        System.out.println(array.get(1));
//        List inlist = searchTree.inOrder();
//        System.out.println(inlist);
//        List postlist = searchTree.postOrder();
//        System.out.println(postlist);
//        Array array1 = searchTree.levelOrder();
//        System.out.println(array1.toString());
//        System.out.println("minItem:"+searchTree1.minItem()+",maxItem:"+searchTree1.maxItem());

        System.out.println(searchTree.removeMaxItemCustom());
        Array array3 = searchTree.levelOrder();
        System.out.println(array3.toString());

        System.out.println(searchTree1.removeMax());
        Array array4 = searchTree1.levelOrder();
        System.out.println(array4.toString());
    }
}
