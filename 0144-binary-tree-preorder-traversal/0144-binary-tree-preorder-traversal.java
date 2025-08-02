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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder_helper(root, result);
        return result;

    }
    public void preorder_helper(TreeNode root, List<Integer> result){
        if(root == null) return;
        
        result.add(root.val);
        preorder_helper(root.left, result);
        preorder_helper(root.right, result);

    }
}