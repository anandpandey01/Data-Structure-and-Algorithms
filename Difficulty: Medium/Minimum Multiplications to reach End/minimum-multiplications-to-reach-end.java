// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start == end) return 0;
        int Mod = 100000;
        boolean[] visited = new boolean[100000];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int value = node[0];  int dist = node[1];
            for(int i=0; i<arr.length; i++){
                int temp = (value * arr[i]) % Mod;
                if(temp == end) return dist+1;
                if(visited[temp]==false){
                    queue.offer(new int[]{temp,dist+1});
                    visited[temp] = true;
                }
            }
        }
        return -1;
    }
}
