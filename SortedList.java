import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.LinkedList;

// SortedList.java

public class SortedList<E extends Comparable<? super E>> extends List<E> {

    private void insertRecursively(Node<E> previous, Node<E> current,Node<E> newNode)
    {
    //Base Case: Insert at this spot bc value is null or less than new node
        if(current == null)
        {
            head = newNode;           
        }
        else if(newNode.data.compareTo(current.data) < 0){
            if(previous == null) //make newNode the head node of the list
            {
                newNode.next = head;
                head = newNode;
            }
            else
            {
                newNode.next = previous.next;
                previous.next = newNode;
            }
        }
    // Recursive Case: run method on next node
        else
            insert(current, current.next, newNode);
    }

    public void insert(E data)
    {
        // Create a node to hold the new data.
        Node<E> newNode = new Node<E>(data);
        insertRecursively(null, head, newNode);
    }


    private void removeRecursively(Node<E> previous, Node<E> current, E data)
    {
        // Base Case: check for null or if you are on the right node
        if(current == null)
            return;
        else if(current.data.compareTo(data) == 0)
        {   
            if(previous == null) //remove head of list
                head = current.next;
            else
                previous.next = current.next;
        }
        // Recursive Case: run method on next node
        else
            remove(current, current.next, data);
    }

    public void remove(E value)
    {
        removeRecursively(null, head, value);
    }  

    public E retrieve(int index){
        return retrieveRecursively(head, index);
    }

    private E retrieveRecursively(Node<E> node, int index){
        if(node == null){
            return;
        }
        else{
            if(index == 0){
                return node.data;
            }
            else{
                retrieveRecursively(node.next,index-1);
            }
        }
    }

    private abstract boolean searchRecursively(Node<E> node, E data){
        //Base case: check if empty list or end of list
        if(node == null){
            return false;
        } 
        //Base case: check if node has data we are looking for
        if(node.data.equals(data)){
            return true;
        }
        //Recursive Case: check next node for data
        else{
            search(node.next, data);
        }
        

    }
    public abstract boolean search(E data){
        return searchRecursively(head, data)
    }
    
    abstract class List<E> implements Iterable<E> {

        protected class Node<T> {
            protected Node(T data) {
            this.data = data;
        }

        protected T data;
        protected Node<T> next;
    }

    public abstract void insert(E data);
    public abstract void remove(E data);
    public abstract E retrieve(int index);
    public abstract boolean search(E data);
    
    protected Node<E> head;
    }
}
