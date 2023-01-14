import java.util.Iterator;
import java.util.Random;

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

    private void searchRecursively(){

    }

    public boolean search(E data){
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinarySearchTree<Integer>();
        Random rand = new Random(1);
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
        System.out.println("insert");

        tree.insert(2);
                
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