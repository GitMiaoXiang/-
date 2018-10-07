package LinkedList;

import Queue.CustomArrayQueue;
import Queue.IQueue;
import Queue.LoopQueue;

import java.util.Random;

public class QueueTest {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();
        int opCount = 10000000;
        double loopTime= testQueue(loopQueue,opCount);
        double arrayTime = testQueue(linkedQueue, opCount);
        System.out.println("loopTime:" +loopTime);
        System.out.println("linkedQueue:"+arrayTime);

    }

    public static double testQueue(IQueue<Integer> queue, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i=0; i<opCount; i++){
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0; i<opCount; i++){
            queue.deQueue();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
