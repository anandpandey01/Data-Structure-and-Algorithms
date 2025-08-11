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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(arr);
        ListNode temphead = new ListNode(arr.get(0));
        curr =  temphead;
        for(int i=1; i<arr.size(); i++){
            curr.next = new ListNode(arr.get(i));
            curr = curr.next;
        }
        return temphead;
    }
}