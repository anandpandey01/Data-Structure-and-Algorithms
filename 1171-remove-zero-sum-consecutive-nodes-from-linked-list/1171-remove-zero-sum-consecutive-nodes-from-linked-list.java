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
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        //if(head == null || head.next == null) return head;
        HashMap<Integer, ListNode> hs = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int prefixSum = 0;
        hs.put(prefixSum,dummyNode);
        ListNode curr = head;

        while(curr!= null){
            prefixSum+= curr.val;
            if(hs.containsKey(prefixSum)){
                ListNode start = hs.get(prefixSum);
                ListNode temp =  start;
                int pSum = prefixSum;
                while(temp!= curr){
                    temp = temp.next;
                    pSum+=temp.val;
                    if(temp != curr){                 // To Save the Last Prefix Sum
                        hs.remove(pSum);
                    }
                }
                start.next = curr.next;
            }
            else{
                hs.put(prefixSum,curr);
            }
            curr = curr.next;
        }
        return dummyNode.next;
    }
}