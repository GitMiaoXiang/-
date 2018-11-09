package Heap;

import DynamicArray.Array;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int cpacity) {
        data = new Array<>(cpacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmptry() {
        return data.isEmpty();
    }


    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        return (index - 1) / 2;
    }

    private int childLeft(int index) {
        return index * 2 + 1;
    }

    private int childRight(int index) {
        return index * 2 + 2;
    }

    //向堆中添加数据
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        return data.get(0);
    }

    public E extractMax() {
        E max = findMax();
        data.swap(0, data.getSize() - 1);
        data.remove(data.getSize() - 1);
        siftDown(0);
        return max;
    }

    private void siftDown(int i) {
        while (childLeft(i) < data.getSize()) {
            int j = childLeft(i);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = childRight(i);
            }
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i, j);
            i = j;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("堆实现有误！！");
            }
        }
        System.out.println("完成");
    }

}
