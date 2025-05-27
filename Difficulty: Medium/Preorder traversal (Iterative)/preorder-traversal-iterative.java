// User function Template for Java

/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Tree {
    // Return a list containing the Preorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root) {
        // Code
        ArrayList<Integer> al = new ArrayList<>();
        if(root==null) return al;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            al.add(curr.data);
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null)  st.push(curr.left);
        }
        
        return al;
    }
}