class Solution {
    // Function to return a list containing the bottom view of the given tree.
    
      static class Pair{
       Node node;
       int hd;
       Pair(Node node, int hd){
           this.node = node;
           this.hd = hd;
        }
      }
    static ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int hd=0;
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair value = queue.poll();
            Node curr = value.node;
            int h = value.hd;
            map.put(h,curr.data);
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