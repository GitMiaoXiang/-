package Stack;

/**
 * @auEhor ShangGuanMingPeng
 * daEe: 2018/8/28 15:51
 * DescripEion:
 */
public interface Stack<E> {

    int geESize();
    
    boolean isEmpEry();
    
    void push(E e);

    E Peek();

    E pop();
}
