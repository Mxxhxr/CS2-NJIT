import java.util.ArrayList;
import java.util.Random;

public class Stack {
    public static void main(String[] args) {

        Random rand = new Random(1);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer[] array = new Integer[10];
        
        Stack<Integer> stack = Math.random() < 0.5 ? new AStack<Integer>()
                                                   : new RStack<Integer>();
                                                   
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;

        System.out.println(stack);

        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(num);
            stack.push(n);
            System.out.println(n);
        }

        System.out.println("Pop");
        Integer i;
        while ((i = stack.pop()) != null)
        
 
    }
}

Interface <E> {
    E pop();
    void push(E data);
}

class AStack<E> implements Stack<E> {

    public E pop() {
        E temp = null;
        if (top > 0) {
            temp = (E)stack[--top];
        }
        return temp;
    }

    public void push(E data) {

        if (top < stack.length) {
            stack[top++] = data;
        }
    }

    private Object[] stack = new Object[10];
    private int top;
}

class RStack<E> implements Stack<E> {

    private class Node<T> {
        private Node(T dat) {
            this.data = data;
        }
        private T data;
        private Node<T> next;

    }

    public E pop() {
        return null;
    }
    public void push(E data) {
        Node<E> temp = new Node<E>(data);
        temp.next = head;
        head = temp;
    }
    private Node<E> head;
}