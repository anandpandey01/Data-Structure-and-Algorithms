/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
        if(root==null) return Integer.MIN_VALUE;
        int max = root.data;
        int leftMax  = findMax(root.left);
        int rightMax = findMax(root.right);
        max = Math.max(max,Math.max(leftMax,rightMax));
        return max;
    }

    public static int findMin(Node root) {
        if(root==null) return Integer.MAX_VALUE;
        int min = root.data;
        int leftMin  = findMin(root.left);
        int rightMin = findMin(root.right);
        min = Math.min(min,Math.min(leftMin,rightMin));
        return min; 
    }
}