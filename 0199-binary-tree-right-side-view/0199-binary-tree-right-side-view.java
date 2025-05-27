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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){ 
            int count = queue.size();
            for(int i=0; i<count;i++){
                TreeNode curr = queue.poll();
                if(i==count-1){
                    result.add(curr.val);
                }
               if(curr.left!=null)  queue.add(curr.left);
               if(curr.right!=null) queue.add(curr.right);   
            }
        }
       return result;
    }
}