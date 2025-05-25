/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        int sum=0;
        if(root==null) return 1;
        if(root.left == null && root.right == null) return 1;
        if(root.left!=null)  sum+= root.left.data;
        if(root.right!=null) sum+= root.right.data;
        if (root.data==sum && 
            isSumProperty(root.left)==1 &&
            isSumProperty(root.right)==1 ) return 1;
        return 0;
    }
}