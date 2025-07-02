class Solution {
    int[] netCount;
    int maxAchievableRequest = Integer.MIN_VALUE;

    public int maximumRequests(int n, int[][] requests) {
        netCount = new int[n];
        solve(requests,0,0);
        return maxAchievableRequest;
    }
    public void solve(int[][] requests,int idx,int count){
        if(idx>=requests.length){
            for(int value : netCount){
                if(value!= 0) return;
            }
            maxAchievableRequest = Math.max(maxAchievableRequest,count);
            return;
        }
        
        int from = requests[idx][0];
        int to = requests[idx][1];
        netCount[from]--;
        netCount[to]++;
        solve(requests, idx + 1, count + 1);
        netCount[from]++;
        netCount[to]--; 
        solve(requests, idx + 1, count);    // Skip current request
        
    }
}