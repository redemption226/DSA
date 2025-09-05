package DSA.Trees;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 */


public class LowestCommonAncestor {


    public static void main(String[] args) {
        Integer[] root = {3,5,1,6,2,0,8,null,null,7,4};
        int p = 5, q = 7;
        int n = root.length;

        TreeNode node = buildTree(root);
        //printInorder(node);
        TreeNode pNode = new TreeNode(p);
        TreeNode qNode = new TreeNode(q);

        TreeNode commonNode = lowestCommonAncestor(node, pNode, qNode);
        System.out.println(commonNode.val);

    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        return helper(arr, 0);
    }

    public static TreeNode helper(Integer[] arr, int i ) {

        if ( i >= arr.length || arr[i] == null) return null;

        TreeNode node = new TreeNode(arr[i]);
        node.left = helper(arr, 2 * i + 1);
        node.right = helper(arr, 2 * i + 2);

        return node;
    }

    // Inorder traversal for testing
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return root;

        if (root.val == p.val)
            return p;

        if (root.val == q.val)
            return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        if (left != null) return left;
        if (right != null) return right;

        return null;
    }

}


