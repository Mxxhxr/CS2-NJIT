import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    private void insertRecursively(Node<E> root, E data){

        if(root == null){
            root = new Node<E>(data);
        }
        else if(root.left == null || root.right == null){
            if(data.compareTo(root.data) <=0 ) root.left = new Node<E>(data);
            else root.right = new Node<E>(data);
        }
        else if(data.compareTo(root.data) <= 0){
            insertRecursively(root.left, data);
        }else{
            insertRecursively(root.right, data);
        }

    }

    public void insert(E data){
        insertRecursively(root, data);
    }

    public void removeRecursively(){

    }

    public void remove(E data ){

    }

    private boolean searchRecursively(Node<E> root, E data){
        if(root == null) {
            return false;
        }
        else if (root.data == data) {
            return true;
        }
        else if (root.data.compareTo(data) < 0) {
            return searchRecursively(root.left, data);
        }
        else {
            return searchRecursively(root.right, data);
        }
        
    }

    public boolean search(E data){
        return searchRecursively(root, data);
    }

    public Iterator<E> iterator() {
        vector = new Vector<E>();
        traverse(root);
        return vector.iterator();
    }

    private void traverse(Node<E> curr) {
        if (curr != null) {
            traverse(curr.left);
            vector.add(curr.data);
            traverse(curr.right);
        }
    }
    private Vector<E> vector;

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinarySearchTree<Integer>();
        Random rand = new Random(1);
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
        System.out.println("insert");

        tree.insert(2);

        System.out.println("search");
        tree.search(2);
        
                
        // for (int i = 0; i < num; ++i) {
        // int n = rand.nextInt(num);
        // tree.insert(n);
        // System.out.print(n + ": ");
        // for (Integer j : tree) {
        // System.out.print(j + " ");
        // }
        // System.out.println();
        // }

    }

}