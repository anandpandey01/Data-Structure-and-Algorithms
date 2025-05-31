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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> seenBefore = new HashSet<>();
        return dfs(root, k, seenBefore);
    }
    public boolean dfs(TreeNode root, int k, HashSet seenBefore){
        if(root == null) return false;
        if(seenBefore.contains(k-root.val)){
            return true;
        }
        seenBefore.add(root.val);
        return dfs(root.left, k, seenBefore) || dfs(root.right, k, seenBefore);
        
    }
}