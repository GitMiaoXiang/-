package LinkedList;

import Stack.Stack;
import Stack.ArrayStack;

import java.util.Random;

public class StackTest {

    public static void main(String[] args) {
        int opCount = 100000;
        LinkedListStack<Integer> listStack = new LinkedListStack<Integer>();
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        System.out.println("listStack:"+testQueue(listStack,opCount));
        System.out.println("arrayStack:"+testQueue(arrayStack,opCount));
    }

    public static double testQueue(Stack<Integer> queue, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i=0; i<opCount; i++){
            queue.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0; i<opCount; i++){
            queue.pop();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
