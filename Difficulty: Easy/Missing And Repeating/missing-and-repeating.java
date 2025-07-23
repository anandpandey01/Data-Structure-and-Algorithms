class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
        }
        int duplicate = -1, missing = -1;
        for(int i=1; i<=n; i++){
            int count = hs.getOrDefault(i,0);
            if(count == 2)  duplicate = i;
            if(count == 0)  missing = i;
        }
        result.add(duplicate);
        result.add(missing);
        return result;
    }
}
