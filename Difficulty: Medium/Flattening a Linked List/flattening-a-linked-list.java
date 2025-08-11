class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root == null) return null;
        Node nextNode = flatten(root.next);
        return mergeTwoSortedList(root, nextNode);
    }
    public Node mergeTwoSortedList(Node l1, Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Node result;
        if(l1.data <= l2.data){
            result = l1;
            result.bottom = mergeTwoSortedList(l1.bottom, l2);
        }
        else{
            result = l2;
            result.bottom = mergeTwoSortedList(l1, l2.bottom);
        }
        return result;
    }
}