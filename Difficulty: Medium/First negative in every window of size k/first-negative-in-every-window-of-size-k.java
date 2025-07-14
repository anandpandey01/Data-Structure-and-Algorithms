class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int n = arr.length;
        int i=0, j=0;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        while(j<n){
            if(arr[j]<0) queue.offer(arr[j]);
            if(j-i+1 == k){
                if(!queue.isEmpty()) result.add(queue.peek());
                else result.add(0);
                if(arr[i]<0) queue.poll();
                i++;
            }
            j++;
        }
        return result;
        
    }
}