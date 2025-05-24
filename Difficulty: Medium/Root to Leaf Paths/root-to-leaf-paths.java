/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current  = new ArrayList<>();
        dfs(root,result,current);
        return result;
    }
    private static void dfs(Node root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current) {
        if(root == null) return;
        current.add(root.data);
        if(root.left==null && root.right == null){
            result.add(new ArrayList<>(current));
        }
        else{
            dfs(root.left,result,current);
            dfs(root.right,result,current);
        }
        
        current.remove(current.size()-1);
       
    }
    
}