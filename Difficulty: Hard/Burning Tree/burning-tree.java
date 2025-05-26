/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    public static int minTime(Node root, int target) {
        HashMap<Integer, Node> parent = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if (curr.left != null) {
                parent.put(curr.left.data, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right.data, curr);
                queue.add(curr.right);
            }
        }  
        HashSet<Integer> visited = new HashSet<>();
        Node targ = findTarget(root,target);
        queue.add(targ);
        visited.add(targ.data); 
        int time=0;
        while (!queue.isEmpty()) {   
             boolean spread = false; 
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();               
                if (curr.left != null && !visited.contains(curr.left.data)) {
                    queue.add(curr.left);
                    visited.add(curr.left.data);
                    spread = true;
                }
                if (curr.right != null && !visited.contains(curr.right.data)) {
                    queue.add(curr.right);
                    visited.add(curr.right.data);
                     spread = true;
                }
                if (parent.containsKey(curr.data) && !visited.contains(parent.get(curr.data).data)) {
                    queue.add(parent.get(curr.data));
                    visited.add(parent.get(curr.data).data);
                     spread = true;
                }
            }
            if (spread) time++;
        }
        return time;
        
    }
    private static Node findTarget(Node root, int target) {
            if (root == null) return null;
            if (root.data == target) return root;
            Node left = findTarget(root.left, target);
            if (left != null) return left;
            return findTarget(root.right, target);
    }
}