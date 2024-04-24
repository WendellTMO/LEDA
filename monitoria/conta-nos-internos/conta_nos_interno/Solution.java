import java.util.Scanner;

public class Solution {
    private BST<Integer> bst;

    public Solution() {
        bst = new BST<>();
    }

    public void add(int element) {
        bst.add(element);
    }

    public int size() {
        return bst.size();
    }

    public int countInternalNodes() {
        return countInternalNodes(bst.getRoot());
    }

    private boolean isLeaf (BST.Node<Integer> node) {
        if (node == null) {
            return true;
        }

        if (node.right == null && node.left == null) {
            return true;
        }

        return false;

        // return node.right == null && node.left == null;
    }

    private int countInternalNodes(BST.Node<Integer> node) {
        // condição parada
        if (node == null || isLeaf(node)) {
            return 0;
        }

        return 1 + countInternalNodes(node.right) + countInternalNodes(node.left);
    }

    public static void main(String[] args) {
        Solution bst = new Solution();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nums = input.split(" ");
        for (String n : nums) {
            int num = Integer.parseInt(n);
            bst.add(num);
        }
        System.out.println(bst.countInternalNodes());
    }
}

class BST<T extends Comparable<T>> {
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<T> root;

    public BST() {
        root = null;
    }

    public void add(T data) {
        root = addRec(root, data);
    }

    private Node<T> addRec(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = addRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = addRec(node.right, data);
        }

        return node;
    }

    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRec(node.left) + sizeRec(node.right);
    }

    public Node<T> getRoot() {
        return root;
    }
}
