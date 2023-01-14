import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    private Node<E> insertRecursively(Node<E> root, E data){

        if(root == null){
            return new Node<E>(data);
        }
        
        if(data.compareTo(root.data) <= 0){
            root.left = insertRecursively(root.left, data);
        }else{
            root.right = insertRecursively(root.right, data);
        }

        return root;

    }

    public void insert(E data){
        root = insertRecursively(root, data);
    }

    public Node<E> removeRecursively(Node<E> root, E data){

        if (root == null) {
            return null;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = removeRecursively(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = removeRecursively(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node<E> minNode = findMin(root.right);
                root.data = minNode.data;
                root.right = removeRecursively(root.right, minNode.data);
            }
        }

        return root;

    }

    public void remove(E data ){
        root = removeRecursively(root,data);
    }

    private Node<E> findMin(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private boolean searchRecursively(Node<E> root, E data){

        if(root == null) {
            return false;
        }
        else if (root.data.compareTo(data) == 0) {
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
        for (int i = 0; i < num; ++i) {
        int n = rand.nextInt(num);
        tree.insert(n);
        System.out.print(n + ": ");
        for (Integer j : tree) {
        System.out.print(j + " ");
        }
        System.out.println();
        }

        System.out.println("\nsearch");
        System.out.println(tree.search(4));

        System.out.println("\nremove");
        tree.remove(4);
        tree.remove(2);

        for (Integer j : tree) {
            System.out.print(j + " ");
        }

    }

}