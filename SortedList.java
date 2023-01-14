//import java.util.List;
import java.util.Iterator;
import java.util.Random;
//import java.util.LinkedList;


public class SortedList<E extends Comparable<? super E>> extends ListMV<E> {

    private void insertRecursively(Node<E> previous, Node<E> current,Node<E> newNode){
    //Base Case: Insert at this spot bc value is null or less than new node
        if(current == null){
            head = newNode;           
        }
        else if(newNode.data.compareTo(current.data) < 0){

            //make newNode the head node of the list
            if(previous == null) { 

                newNode.next = head;
                head = newNode;
            }
            else {
                newNode.next = previous.next;
                previous.next = newNode;
            }
        }
        else if(newNode.data.compareTo(current.data) >= 0 && current.next == null){
            current.next = newNode;
        }
        // Recursive Case: run method on next node
        else
            insertRecursively(current, current.next, newNode);
    }

    public void insert(E data){
        // Create a node to hold the new data.
        Node<E> newNode = new Node<E>(data);
        insertRecursively(null, head, newNode);
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
          public boolean hasNext() {
            return curr != null;
          }
          public E next() {
            E temp = curr.data;
            curr = curr.next;
            return temp;
          }
          private Node<E> curr = head;
        };
    }

    private void removeRecursively(Node<E> previous, Node<E> current, E data) {
        // Base Case: check for null or if you are on the right node
        if(current == null)
            return;
        else if(current.data.compareTo(data) == 0) {   
            if(previous == null) //remove head of list
                head = current.next;
            else
                previous.next = current.next;
        }
        // Recursive Case: run method on next node
        else
            removeRecursively(current, current.next, data);
    }

    public void remove(E value) {
        removeRecursively(null, head, value);
    }  

    private E retrieveRecursively(Node<E> node, int index, int i) throws IndexOutOfBoundsException {

        if(node == null) {
            throw new IndexOutOfBoundsException();
        }
        else if(i == index) {
            return node.data;
        }
        else {
            return retrieveRecursively(node.next, index, i+1);
        }
    }
    
    public E retrieve(int index) {
        return retrieveRecursively(head, index, 0);
    }

    private boolean searchRecursively(Node<E> node, E data) {
        //Base case: check if empty list or end of list

        if(node == null) {
            return false;
        } 
        //Base case: check if node has data we are looking for
        else if(node.data.equals(data)) {
            return true;
        }
        //Recursive Case: check next node for data
        else {
            return searchRecursively(node.next, data);
        }
        
    }
    
    public boolean search(E data) {
        return searchRecursively(head, data);
    } 
    
    public static void main(String[] args) {

        ListMV<Integer> list = new SortedList<Integer>();
        Random rand = new Random(1);
        int n, num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
        //long start, stop; 

        System.out.println("Insert: ");
        for (int i = 0; i < num; ++i) {
            n = rand.nextInt(num);
            list.insert(n);
            System.out.print(n + " => ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("\nSearch for "+6+": "+list.search(6));

        System.out.println("\nRetrieve at Index "+2+": "+list.retrieve(2));

        rand = new Random(1);
        System.out.println("\nRemove: ");
        for (int i = 0; i < num; ++i) {
            n = rand.nextInt(num);
            list.remove(n);
            System.out.print(n + " => ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
