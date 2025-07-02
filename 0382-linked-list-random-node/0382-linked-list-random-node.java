/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {  // Naive
    List<Integer> arr;

    public Solution(ListNode head) {
        arr = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }    
    }
    
    public int getRandom() {
        int size = arr.size();
        Random random = new Random();
        int random_index = random.nextInt(arr.size());    // arr.size() is exclusive
        return arr.get(random_index);

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */