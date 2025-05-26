/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, TreeNode> parent = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                parent.put(curr.left.val, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right.val, curr);
                queue.add(curr.right);
            }
        }  
        HashSet<Integer> visited = new HashSet<>();
        queue.add(target);
        visited.add(target.val); 
        while (k > 0 && !queue.isEmpty()) {   
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr.val);
                if (curr.left != null && !visited.contains(curr.left.val)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right.val)) {
                    queue.add(curr.right);
                }
                if (parent.containsKey(curr.val) && !visited.contains(parent.get(curr.val).val)) {
                    queue.add(parent.get(curr.val));
                }
            }
            k--;
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;

    }
}