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
    public ListNode[] splitListToParts(ListNode head, int k) {
       ListNode curr = head;
       int n = 0;
        while(curr!= null){
            curr = curr.next;
            n++;
        }
        ListNode[] result = new ListNode[k];
        int size = n/k;   int rem = n%k;
        curr = head;
        ListNode prev = null;
        for(int i=0; i<k; i++){
            result[i] = curr;
            for(int j=1; j<=(size+((rem>0)?1:0)); j++){
                prev = curr;
                curr = curr.next;
            }   
            if(prev!= null){
                prev.next = null;
            } 
            
            rem--;
        }
        return result;
    }
}