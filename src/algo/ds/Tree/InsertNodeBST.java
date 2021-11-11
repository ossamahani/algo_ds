package algo.ds.Tree;

import java.util.List;

public class InsertNodeBST {

    static class Node {
        int data;
        Node right;
        Node left;
    }

    public static void main(String[] args) {
        List<Integer> dataInput = List.of(100, 80, 50, 90, 30, 60, 90, 85, 95, 120, 110, 108, 115, 140, 150);
        Node root = null;
        for(Integer node : dataInput) {
           root = insert(root, node);
        }
        printLeaves(root);
    }
    

public static Node insert(Node head, int data) {
    if(head == null) {
        head = new Node();
        head.data = data;
        return head;
    }
    if(head.data < data) {
        head.right = insert(head.right, data);
    } else {
        head.left = insert(head.left, data);
    }
    return head;
}


public static void printLeaves(Node head) {
    if(head == null) {
        return;
    }
    if(head.right == null && head.left == null) {
        System.out.println(head.data + ", ");
        return;
    }
    if(head.left != null) {
        printLeaves(head.left);
    }
    if(head.right != null) {
        printLeaves(head.right);
    }
}
}
