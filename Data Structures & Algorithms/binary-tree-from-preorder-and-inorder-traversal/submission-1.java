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
    int preIn = 0;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(preorder, 0, inorder.length-1);    
    }
    private TreeNode build(int[] preorder, int l , int r)
    {
        if(l > r)
        return null;

        int val = preorder[preIn++];
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, l, map.get(val) - 1);
        root.right = build(preorder, map.get(val) + 1, r);
        return root;
    }
}
