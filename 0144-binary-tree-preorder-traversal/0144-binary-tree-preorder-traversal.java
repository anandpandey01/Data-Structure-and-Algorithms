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
        ArrayList<Integer> al = new ArrayList<>();
        preorderHelper(root, al);
        return al;
    }
    public void preorderHelper(TreeNode root, List<Integer> al){
        if(root!=null){
            al.add(root.val);
            preorderHelper(root.left,al);
            preorderHelper(root.right,al);
        }
       
    }
}