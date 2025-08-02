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
        Queue<TreeNode> dq = new LinkedList<>();
        List<List<Integer>> al = new ArrayList<>();
        if (root == null) return al;
        dq.add(root);
        dq.add(null);
        int size=dq.size();
        List<Integer> row = new ArrayList<>();
        while(dq.size()>1){
            TreeNode curr = dq.poll();
            if(curr==null){
                al.add(new ArrayList<>(row)); // Finish current level
                row.clear(); 
                dq.add(null);
                continue;
            }
            row.add(curr.val);
            
            if(curr.left!=null)  dq.add(curr.left);
            if(curr.right!=null) dq.add(curr.right);
        }
         al.add(row);
         return al;
    }
}