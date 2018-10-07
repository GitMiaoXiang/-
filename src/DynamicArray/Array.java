package DynamicArray;

public class Array<E> {

    private int size;

    private E[] data;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array(){
        this.data = (E[]) new Object[10];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public E first(){
        return get(0);
    }

    public E last(){
        return get(size-1);
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E t){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("添加失败,位置不合法");
        }
        for(int i = size - 1; i >= index ; i--){
            data[i+1] = data[i];
        }
        if(size == data.length){
            resize(2*data.length);
        }
        data[index] = t;
        size++;
    }

    public void addLast(E e){
        add(size , e);
    }

    public void addFirst(E e){
        add(0 , e);
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("位置不合法");
        }
        return  data[index];
    }

    private void resize(int index) {
       E[] newData = (E[]) new Object[index];
       for (int i = 0 ; i < size ; i++){
           newData[i] = data[i];
       }
       data = newData;
    }

    public void set(int index , E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("位置不合法");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for(int i = 0 ; i < size ; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public E remove(int index){
        E ret = data[index];
        for(int i = index + 1; i < size ; i++){
            data[i-1] = data[i];
        }
        size--;
        //使用泛型时，最后的元素会存在一个引用，jvm不会自动回收，置为空的话会被jvm回收。
        data[size] = null;
        if(size == data.length/2 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("size:"+size+",length"+data.length+"\n");
        stringBuffer.append("[ ");
        for (int i = 0; i<size ; i++){
            if(i == 0){
                stringBuffer.append(data[i]);
            }else{
                stringBuffer.append(","+data[i]);
            }
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }


}
