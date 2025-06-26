class Solution {
    public int[][] merge(int[][] arr) {
       int n =  arr.length;
       List<int[]> result = new ArrayList<>();
       Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));  // Based on start time
       result.add(arr[0]);               //result.add(new int[]{arr[0][0],arr[0][1]}); 
       for(int i=1; i<n; i++){
            int currStart = arr[i][0]; int currEnd = arr[i][1]; 
            int[]prev=  result.get(result.size() - 1);
            if(prev[1] >= currStart){
                //int min= Math.min(currStart,prevStart); Not necessary because already sorted by start
                prev[1] = Math.max(prev[1], currEnd);   // Modify in existing Prev
            }
            else{
                result.add(new int[]{currStart,currEnd});   // result.add(intervals[i]);
            }
       }
       return result.toArray(new int[result.size()][]);
    }
}




// int currEnd =  arr[0][1];
//        int currStart = arr[0][0];
//        for(int i=1; i<n; i++){
//           int nextStart = arr[i][0]; int nextEnd = arr[i][1];
//           if(currEnd>=nextStart){
//                 currEnd = Math.max(currEnd, nextEnd);
//           }
//           else{
//             result.add(new int[]{currStart, currEnd});
//             currStart = nextStart;
//             currEnd = nextEnd;

//           }
//        }
//        result.add(new int[]{currStart, currEnd}); 
//        return result.toArray(new int[result.size()][]);     