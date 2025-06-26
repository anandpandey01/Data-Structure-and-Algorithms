class Solution {                                    
    public int eraseOverlapIntervals(int[][] arr) {
        int n= arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1])); // Sorting by endtime simplifies it 
        int count = 0;
        int currEnd = arr[0][1];       

        for (int i = 1; i < n; i++) {
            int nextStart = arr[i][0];
            if (currEnd > nextStart) {
                    count++;            // overlapping interval
                } else {
                    currEnd = arr[i][1]; // update end if no overlap
                }
            }

        return count;
    }
}