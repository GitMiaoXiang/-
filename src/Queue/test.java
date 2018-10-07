package Queue;

import java.util.Random;

public class test {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        CustomArrayQueue<Integer> arrayQueue = new CustomArrayQueue<>();
        double loopTime= testQueue(loopQueue,10000000);
//        double arrayTime = testQueue(arrayQueue, 1000000);
        System.out.println("loopTime:" +loopTime);
//        System.out.println("arrayTime:"+arrayTime);

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
