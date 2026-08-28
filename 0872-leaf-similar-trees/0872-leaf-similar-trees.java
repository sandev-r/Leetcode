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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        isSimilar(root1, result1);
        isSimilar(root2, result2);

        return result1.equals(result2);

    }

    private void isSimilar(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }

        isSimilar(root.left, result);
        isSimilar(root.right, result);
    }
}