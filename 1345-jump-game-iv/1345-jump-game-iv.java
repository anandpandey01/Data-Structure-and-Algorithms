class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n== 1) return 0;
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            if(hs.containsKey(arr[i]) == false){
                hs.put(arr[i],new ArrayList<>());
            }
            hs.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int curr = queue.poll();
                if(curr == n-1) return steps;

                int left = curr-1; int right = curr+1;
                if(left>=0 && visited[left] == false){
                    visited[left]= true;
                    queue.offer(left);
                }
                if(right<n && visited[right] == false){
                    visited[right]= true;
                    queue.offer(right);
                }
                if(hs.containsKey(arr[curr])){
                    for(int j : hs.get(arr[curr])){
                        if(j!= curr && visited[j] == false){
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    hs.remove(arr[curr]);
                }
            }
            steps++;    
        }
        return steps;
    }
}