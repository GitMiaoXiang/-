package Queue;

import DynamicArray.Array;

public class ArrayQueue<E> implements IQueue<E> {

    private int front, tail;

    private int size;

    private E[] data;

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public ArrayQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public E deQueue() {
        E item = data[front];
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        tail--;
        data[size] = null;
        if (size == data.length / 2 && data.length != 0) {
            resize(data.length / 2);
        }
        return item;
    }

    @Override
    public void enQueue(E e) {
        if (size == data.length) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail++;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public E front() {
        return data[front];
    }

    @Override
    public E tail() {
        return data[tail];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
