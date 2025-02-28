import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 from RIGHT to LEFT
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Maintain a decreasing stack
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // If stack is empty, no greater element; otherwise, stack's top is NGE
            nextGreaterMap.put(num, stack.isEmpty() ? -1 : stack.peek());

            // Push the current element to stack
            stack.push(num);
        }
        
        // Build the result array for nums1 using the hash map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
}
