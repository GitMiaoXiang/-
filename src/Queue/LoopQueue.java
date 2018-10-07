package Queue;

public class LoopQueue<E> implements IQueue<E>{

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public  LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    /**
     * 出队
     * @param
     */
    @Override
    public E deQueue() {
        if(isEmpty()){
            System.out.println("队列对空");
        }
        E ret = data[front];
        front = (front+1)%data.length;
        size--;
        if(size == getCapacity()/4&&getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enQueue(E e) {
        if((tail+1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i<size; i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E front() {
        if(isEmpty()){
            System.out.println("队列为空");
        }
        return data[front];
    }

    @Override
    public E tail() {
        if(isEmpty()){
            System.out.println("队列为空");
        }
        return data[tail];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i=(i+1)%data.length){
            sb.append(data[i]);
            if((i + 1)%data.length != tail){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
