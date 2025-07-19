class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;  int m = b.length;
        int k = 0;
        int [] temp = new int[n+m];
        int len = temp.length;
        for(int i=0; i<n; i++) temp[k++] =  a[i];
        for(int j=0; j<m; j++) temp[k++] =  b[j];
        
        Arrays.sort(temp);
        result.add(temp[0]);
        
        for(int x=0; x<len; x++){
            if(temp[x] != result.get(result.size()-1)){
                result.add(temp[x]);
            }
        }
        return result;
        
    }
}