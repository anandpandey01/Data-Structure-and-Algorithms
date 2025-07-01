/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public int GetNth(Node head, int index) {
        // Code here
        int position = 1;
        Node curr = head;
        while(curr != null && position !=index ){
            curr = curr.next;
            position++;
        }
        if(curr == null) return -1;
        else return curr.data;
    }
}