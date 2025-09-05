package DSA.Trees;

import java.util.Arrays;
import java.util.List;

public class DFSBinaryTree {
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {


        //      5
        //     / \
        //   12   13
        //   /  \    \
        //  7    14    2
        // /  \   /  \  / \
        //17  23 27  3  8  11

        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);

        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        dfs(root);

//        for (List<Integer> val : res) {
//            System.out.println(Arrays.toString(val.toArray()));
//        }
    }
    
    public static void dfs(Node root) {

        if (root  == null) return;

        System.out.println(root.data);
        if (root.left!=null) dfs(root.left);
        if (root.right!=null) dfs(root.right);
    }

}
