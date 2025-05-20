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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<List<Integer>> al = new ArrayList<>();
        if(root==null) return al;
        st1.push(root);
        while(!st1.isEmpty() || !st2.isEmpty()){  
            List<Integer> row1 = new ArrayList<>();
            while(!st1.isEmpty()){
                TreeNode curr = st1.pop();        
                row1.add(curr.val);
                
                if(curr.left!=null)  st2.push(curr.left); 
                if(curr.right!=null) st2.push(curr.right);      
            }
            if(row1.size()>0) al.add(row1);

            List<Integer> row2 = new ArrayList<>();
            while(!st2.isEmpty()){
                TreeNode curr = st2.pop();       
                row2.add(curr.val);
                if(curr.right!=null) st1.push(curr.right);
                if(curr.left!=null)  st1.push(curr.left);
                
            }
            if(row2.size()>0)  al.add(row2);
        }
        return al;

    }
}