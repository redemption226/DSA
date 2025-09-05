package DSA.Trees;


import java.util.*;

public class BFSBinaryTree {

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

        List<List<Integer>> res = bfs(root);

        for (List<Integer> val : res) {
            System.out.println(Arrays.toString(val.toArray()));
        }
    }

    public static List<List<Integer>> bfs (Node root) {

        List<List<Integer>> res = new ArrayList<>();


        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size  = q.size();

            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                Node temp = q.poll();
                ls.add(temp.data);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            res.add(ls);
            level++;
        }
        System.out.println(level);
        return res;
    }
}
