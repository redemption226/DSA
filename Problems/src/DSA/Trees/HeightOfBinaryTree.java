package DSA.Trees;

public class HeightOfBinaryTree {
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

        System.out.println(height(root));
    }

    public static int height(Node root) {

        if (root  == null) return 0;
        int hl = height(root.left);
        int hr = height(root.right);

        return 1 + Math.max(hl,hr);
    }
}
