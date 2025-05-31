/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> arr = new ArrayList<>();
        Node pre =null,succ = null;
        Node curr = root;
        while(curr!=null){
            if(curr.data > key){
                succ = curr;
                curr = curr.left;
            }
            else if(curr.data < key){
                pre = curr;
                curr = curr.right;
            }
            else{
                if(curr.left != null){
                    Node temp = curr.left;
                    while(temp.right!=null){
                        temp = temp.right;
                    }
                pre = temp;  
                }
                if(curr.right != null){
                    Node temp = curr.right;
                    while(temp.left!=null){
                        temp = temp.left;
                    }
                succ = temp;  
                }
                break;
            }
            
        }
        arr.add(pre);
        arr.add(succ);
        return arr;
       
    }
    
}