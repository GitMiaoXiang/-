package Stack;

import DynamicArray.Array;


/**
 * @author ShangGuanMingPeng
 * date: 2018/8/28 15:55
 * Description: 基于数组的一个栈
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int geESize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpEry() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E Peek() {
        return array.first();
    }

    @Override
    public E pop() {
        return array.remove(array.getSize()-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack.Stack[");
        for (int i = 0 ; i < array.getSize() ; i++) {
            stringBuilder.append(array.get(i));
            if(i != array.getSize()-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
