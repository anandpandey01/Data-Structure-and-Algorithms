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
    public List<Integer> inorderTraversal(TreeNode root) {   // Left Root Right
        ArrayList<Integer> al = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                al.add(curr.val);
                curr= curr.right;             
            }
            else{
                TreeNode predecessor = findPredecessor(curr);
                if(predecessor.right== null){
                    predecessor.right=curr;
                    curr= curr.left;
                }
                else{
                    predecessor.right=null;
                     al.add(curr.val);
                    curr = curr.right;
                }

            }
        }
        return al;
    }
    public TreeNode findPredecessor(TreeNode node){
        TreeNode pred = node.left;
        while(pred.right!=null && pred.right!=node ){
            pred=pred.right;
        }
        return pred;
    }
}