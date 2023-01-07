import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.LinkedList;


public abstract class SortedList<E extends Comparable<? super E>> extends ListMV<E> {

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
            insertRecursively(current, current.next, newNode);
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

    public void remove(ListMV<E>.Node<E> current, ListMV<E>.Node<E> next, E value)
    {
        removeRecursively(null, head, value);
    }  

    private E retrieveRecursively(Node<E> node, int index) throws IllegalStateException {
        try {
            if(node == null){
                throw new IllegalStateException("List is empty");
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
        catch (IllegalStateException e) {
            System.out.println("Illegal State Exception");
        }
        return null;
    }
    
    public E retrieve(int index){
        return retrieveRecursively(head, index);
    }

    private boolean searchRecursively(Node<E> node, E data){
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

        return false;
        
    }
    
    public boolean search(Node<E> node, E data){
        return searchRecursively(node, data);
    }
    
}
