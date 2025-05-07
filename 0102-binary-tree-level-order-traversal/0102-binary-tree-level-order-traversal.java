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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> dq = new LinkedList<>();
        if(root==null) return al;
        dq.add(root);
        while (!dq.isEmpty()) {
            int count = dq.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode curr = dq.poll();
                row.add(curr.val);
                if (curr.left != null)   dq.add(curr.left);
                if (curr.right != null)  dq.add(curr.right);
            }
            al.add(row);
        }
        return al;
    }
}