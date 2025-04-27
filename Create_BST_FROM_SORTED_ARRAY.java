/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {
        TreeNode root;
        int left;
        int right;
        Pair(TreeNode root, int left, int right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length - 1;
        int mid = n / 2;
        Queue<Pair> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[mid]);
        q.add(new Pair(root, 0, n));
        while(!q.isEmpty()) {
            Pair d = q.poll();
            TreeNode curr = d.root;
            int s = d.left, e = d.right;
            int index = s + (e - s) / 2;
            if (s < index) {
                mid = s + (index - 1 - s) / 2;
                TreeNode left = new TreeNode(nums[mid]);
                curr.left = left;
                q.add(new Pair(left, s, index - 1));
            }

            if (e > index) {
                mid = index + 1 + (e - index - 1) / 2;
                TreeNode right = new TreeNode(nums[mid]);
                curr.right = right;
                q.add(new Pair(right, index + 1, e));
            }
        }
        return root;
    }

    // Recursive Method

    // public TreeNode insertIntoBST(int[] nums, int left, int right) {
    //     if (left > right) return null;
    //     int mid = left + (right - left) / 2;
    //     TreeNode node = new TreeNode(nums[mid]);
    //     node.left = insertIntoBST(nums, left, mid-1);
    //     node.right = insertIntoBST(nums, mid+1, right);
    //     return node;
    // }
}