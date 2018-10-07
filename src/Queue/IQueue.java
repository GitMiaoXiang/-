package Queue;

public interface IQueue<E> {

    /**
     * 出队
     * @return
     */
    E deQueue();

    /**
     * 入队
     * @return
     */
    void enQueue(E e);

    /**
     * 队首
     * @return
     */
    E front();

    /**
     * 队尾
     * @return
     */
    E tail();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列中多少元素
     * @return
     */
    int getSize();
}
