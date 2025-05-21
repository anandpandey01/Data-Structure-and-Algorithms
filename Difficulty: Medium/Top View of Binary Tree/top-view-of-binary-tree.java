// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        class Pair{
            Node node;
            int hd;
            Pair(Node n, int h){
               node = n;
               hd = h;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair curr =  queue.poll();
            Node temp = curr.node;
            int hd = curr.hd;
            if(!map.containsKey(hd)){
                map.put(hd,temp.data);  
            }
            if(temp.left!=null) {
                queue.add(new Pair(temp.left,hd-1));
            }
            if(temp.right!=null) {
                queue.add(new Pair(temp.right,hd+1));
            }
        }
        
        al.addAll(map.values());
        return al;
        
    }
        
    }
