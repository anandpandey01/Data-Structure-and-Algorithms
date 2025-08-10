class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        int[][] arr = new int[n][2];
        
        for(int i=0; i<n; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        // Sort By End time to maximize the number of non-overlapping meetings.
        Arrays.sort(arr,(a,b)-> Integer.compare(a[1],b[1]));
        
        int result = 1;
        int[] prev = arr[0];
        for(int i=1; i<n; i++){
            int curStart = arr[i][0];
            if(curStart > prev[1]){
                result++;
                prev = arr[i];
            }
            
        }
        return result;
        
    }
}
