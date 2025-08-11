/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Node left = head, right = head;
        while(right.next != null){
            right = right.next;
        }
  
        while(left != right && right.next != left){
            int num1 = left.data, num2 = right.data;
            if(num1 + num2 > target){
                right = right.prev;
            }
            else if(num1 + num2 < target){
                left = left.next;
            }
            else{
                ArrayList<Integer> row = new ArrayList<>();
                row.add(left.data);    row.add(right.data); 
                result.add(row);
                left = left.next;  right = right.prev;
            }
        }
        return result;
    }
}
