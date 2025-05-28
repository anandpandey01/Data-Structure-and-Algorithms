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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int is = 0;
        int ie = inorder.length-1;
        return buildTree_helper(preorder, inorder, is, ie);
    }
    int preIndex=0;
    public TreeNode buildTree_helper(int[] preorder, int[] inorder, int is, int ie) {
            if(is>ie) return null;
            int inIndex=0;
            TreeNode root = new TreeNode(preorder[preIndex++]);
            for(int i=is; i<=ie; i++){
                if(inorder[i] == root.val){
                    inIndex = i;
                    break;
                }
            }
            root.left =  buildTree_helper(preorder,inorder,is,inIndex-1);
            root.right = buildTree_helper(preorder,inorder,inIndex+1,ie);
            return root;
    }
}