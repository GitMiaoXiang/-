package LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i<5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.add(3,666);
        System.out.println(linkedList.toString());
        linkedList.remove(3);
        System.out.println(linkedList.toString());
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        linkedList.removeLast();
        System.out.println(linkedList.toString());
    }
}
