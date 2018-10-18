package Map;

import BST.BinarySearchTree;

/**
 * @Author:上官名鹏
 * @Description:
 * @Date:Create in 2018/10/18 22:12
 * Modified By:
 */
public class BSTMap<K extends Comparable,V> implements IMap<K,V> {

    private class Node{

        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node root;

    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }


    private Node add(Node root, K key, V value ){
        if(root == null){
            size++;
            root = new Node(key,value);
            return root;
        }
        if(key.compareTo(root.key)<0){
            root.left =  add(root.left,key ,value);
        }else if(key.compareTo(root.key)>0){
            root.right = add(root.right,key,value);
        }else{
            root.value = value;
        }
        return root;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)==0){
            return node;
        }else if(key.compareTo(node.key)>0){
            return getNode(node.right,key);
        }else {
            return getNode(node.left,key);
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key) {
        if(node==null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
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

    private Node minItem(Node root) {
        if(root.left==null){
            return root;
        }
        return minItem(root.left);
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
    
    

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(root,key).value;
    }

    @Override
    public void set(K key, V vallue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException("不存在Key");
        }
        node.value = vallue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }



}
