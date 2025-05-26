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
    static class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index; 
        }
    }
    public int countNodes(TreeNode root) {
      if(root==null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int sum=0;
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){        
            int count = queue.size();
            int startIndex = 0, endIndex = 0;
            for(int i=0; i<count; i++){
                Pair curr = queue.poll();
                if(i==0) startIndex = curr.index;
                if(i==count-1)  endIndex = curr.index ;
                if(curr.node.left!=null) queue.add(new Pair(curr.node.left,2*curr.index+1));
                if(curr.node.right!=null) queue.add(new Pair(curr.node.right,2*curr.index+2));
            }  
            sum=  sum+ (endIndex-startIndex+1);        
        }
        return sum;  
    }
}