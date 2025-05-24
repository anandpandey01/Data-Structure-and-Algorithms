/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        if(Path(root,p,list1) == false
            || Path(root,q,list2) == false) return null;
        int len = Math.min(list1.size(),list2.size()); 
        for(int i=0;i<len-1; i++){
            if(list1.get(i+1)!= list2.get(i+1)) return list1.get(i);
        }
        return list1.get(len-1);
    }

    public boolean Path(TreeNode root, TreeNode match, ArrayList<TreeNode> list ){  
        if(root==null) return false;
        list.add(root);
        if(root == match) return true;
        if(Path(root.left,match,list)|| Path(root.right,match,list)) return true;
        list.remove(list.size()-1);
        return false;
    }
}