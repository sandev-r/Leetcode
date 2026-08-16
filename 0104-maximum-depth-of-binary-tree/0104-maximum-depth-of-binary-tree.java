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
    public int maxDepth(TreeNode root) {
        int result = maxDepthOfBinTree(root);
        return result;
    }

    public int maxDepthOfBinTree(TreeNode node){
        if(node == null){
            return 0;
        }
        int l1 = maxDepthOfBinTree(node.left);
        int l2 = maxDepthOfBinTree(node.right);



        return 1 + Math.max(l1, l2);

    }
}