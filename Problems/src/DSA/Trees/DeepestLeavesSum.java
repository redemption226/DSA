package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

 */
public class DeepestLeavesSum {
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode curr = q.poll();

            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] root = {1,2,3,4,5,null,6,7,null,null,null,null,8};

        TreeNode node = buildTree( root);

        System.out.println(leaveSum(node));
    }

    public static int leaveSum (TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;

        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            sum =0;
            int size  = q.size();
            for (int i=0; i<size; i++ ) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                sum += node.val;
            }
            //System.out.println(sum);
            level++;
            //System.out.println("LEVEL " + level);
        }

        return sum;
    }


}
