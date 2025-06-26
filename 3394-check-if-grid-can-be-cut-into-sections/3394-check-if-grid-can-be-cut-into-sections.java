class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> horizontal = new ArrayList<>();
        List<int[]> vertical = new ArrayList<>();

        for (int[] coordinate : rectangles) {
            int x1 = coordinate[0];
            int y1 = coordinate[1];
            int x2 = coordinate[2];
            int y2 = coordinate[3];

            horizontal.add(new int[]{x1, x2});
            vertical.add(new int[]{y1, y2});
        }

        int[][] horArray = horizontal.toArray(new int[horizontal.size()][]);
        int[][] vertArray = vertical.toArray(new int[vertical.size()][]);

        int[][] result1 = merge(horArray);
        if (result1.length >= 3) {
            return true;
        }

        int[][] result2 = merge(vertArray);
        return result2.length >= 3;
    }
    public int[][] merge(int[][] arr) {
       int n =  arr.length;
       List<int[]> result = new ArrayList<>();
       Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));
       result.add(arr[0]);
       for(int i=1; i<n; i++){
            int currStart = arr[i][0]; int currEnd = arr[i][1]; 
            int[]prev=  result.get(result.size() - 1);
            if(prev[1] > currStart){
                prev[1] = Math.max(prev[1], currEnd);
            }
            else{
                result.add(arr[i]);  
            }
       }
       return result.toArray(new int[result.size()][]);
    }
}