package Queue;

import Heap.MaxHeap;

import java.util.Queue;

public class PriorityQueue<E extends Comparable<E>> implements IQueue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(MaxHeap<E> maxHeap) {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E front() {
        return maxHeap.findMax();
    }

    @Override
    public E tail() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmptry();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }
}
