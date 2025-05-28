/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(node==null) return result;
        if(!isLeaf(node)) result.add(node.data);
        addLeftBoundary(node.left,result);
        addLeafNodes(node,result);
        addRightBoundary(node.right,result);
        return result;
    }
    
    public boolean isLeaf(Node root){
        return (root.left==null && root.right== null);
    }
    
    public void addLeftBoundary(Node node, ArrayList<Integer> result){
       while(node!=null){
           if(!isLeaf(node)) result.add(node.data);
           if(node.left!=null) node= node.left;
           else node = node.right;
       }
    }
    public void addLeafNodes(Node node, ArrayList<Integer> result){
       if(node==null) return;
        if(isLeaf(node)){
            result.add(node.data);
            return;
        }
        addLeafNodes(node.left,result);
        addLeafNodes(node.right,result);
    }
    public void addRightBoundary(Node node, ArrayList<Integer> result){
        Stack<Integer> st = new Stack<>();
        while(node!=null){
            if(!isLeaf(node)) st.add(node.data);
            if(node.right!=null) node= node.right;
            else node= node.left;
        }
        while(!st.isEmpty()){
            result.add(st.pop());
        }
    }
    
    
}