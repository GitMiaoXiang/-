package Queue;

import DynamicArray.Array;

public class CustomArrayQueue<E> implements IQueue<E>{

    private Array<E> array;

    public CustomArrayQueue(int capacity){
        array = new Array<>(capacity);
    }


    public CustomArrayQueue(){
        array = new Array<>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public E deQueue() {
        return array.remove(0);
    }

    @Override
    public void enQueue(E e) {
       array.addLast(e);
    }

    @Override
    public E front() {
        return array.get(0);
    }

    @Override
    public E tail() {
        return array.get(getSize());
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n",array.getSize(),getCapacity()));
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if(i+1!=getSize()){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
