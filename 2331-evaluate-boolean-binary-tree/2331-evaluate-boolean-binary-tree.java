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
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0)
            return false;
        if(root.val == 1)
            return true;

        boolean right = evaluateTree(root.right);
        boolean left = evaluateTree(root.left);

        if(root.val == 2)
            return right || left;
        return right && left;   
    }
}