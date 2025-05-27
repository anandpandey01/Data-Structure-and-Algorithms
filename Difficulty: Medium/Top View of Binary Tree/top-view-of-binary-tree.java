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
    
    static class Pair{
       Node node;
       int hd;
       Pair(Node node, int hd){
           this.node = node;
           this.hd = hd;
       }
    }
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int hd=0;
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair value = queue.poll();
            Node curr = value.node;
            int h = value.hd;
            if(!map.containsKey(h)){
                map.put(h,curr.data);
            }
            if(curr.left!=null){
                queue.add(new Pair(curr.left,h-1));
            }
            if(curr.right!=null){
               queue.add(new Pair(curr.right,h+1));
            }
        }
        result.addAll(map.values());
        return result;
    }
}