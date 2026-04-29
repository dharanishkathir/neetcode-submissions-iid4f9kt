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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean rem = dfs(root, null, target);
        return rem? null : root;
    }
    private boolean dfs(TreeNode root, TreeNode parent, int target)
    {
        if(root.left == null && root.right == null && root.val == target)
        {
            return true;
        }
        if(root.right != null && dfs(root.right, null, target))
        {
            root.right = null;
        }
        if(root.left != null && dfs(root.left, null, target))
        {
            root.left = null;
        }
        if(root.left == null && root.right == null && root.val == target)
        {
            return true;
        }
        return false;
    }
}