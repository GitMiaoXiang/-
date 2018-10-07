package LinkedList;

import Queue.IQueue;

public class LinkedQueue<E> implements IQueue<E> {

    private Node head,tail;

    private int size;

    private class Node{
        private E e;
        private Node next;

        //中间插入
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        //尾部插入
        public Node(E e) {
            this(e,null);
        }

        //初始化一个空的Node
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            System.out.println("为空");
        }
        Node retNode = head;
        head = retNode.next;
        retNode.next = null;
        if(head==null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public void enQueue(E e) {
        if(tail==null){
            tail = new Node(e);
            head = tail;
        }{
            tail.next = new Node(e,null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E front() {
        if(isEmpty()){
            System.out.println("队列为空");
        }
        return head.e;
    }

    @Override
    public E tail() {
        return tail.e;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }



}
