class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
         int n = accounts.size();
        int[] parent = new int[n];   for(int i=0; i<n; i++) parent[i] = i;
        int[] rank = new int[n];
        HashMap<String, Integer> map = new HashMap<>();    // Map to store email -> account index

        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(parent, rank, i, map.get(email));
                }
            }
        }

        // Group emails by their parent account/component
        HashMap<Integer, List<String>> comp = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i = entry.getValue();
            int u = findParent(parent,i); 
            String email = entry.getKey();
            if (!comp.containsKey(u)) {
                comp.put(u, new ArrayList<>());
            }
                comp.get(u).add(email);
            }

        // Prepare the result list
        List<List<String>> result = new ArrayList<>();
        for (int i : comp.keySet()) {
            List<String> emails = comp.get(i);
            Collections.sort(emails); 
            emails.add(0, accounts.get(i).get(0));
            result.add(emails);
        }
        return result;
    }

    public static int findParent(int[] parent, int x){
        if(parent[x] != x) parent[x] = findParent(parent, parent[x]);
        return parent[x];
    }
    public static void union(int[] parent, int[] rank, int x, int y){
        
        int px = findParent(parent, x);
        int py = findParent(parent, y);
        
        if(px == py) return ;
        if(rank[px] > rank[py]){
           parent[py] = parent[px]; 
        }
        else if(rank[py] > rank[px]){
            parent[px] = parent[py]; 
        }
        else{
            parent[py] = parent[px]; 
            rank[px]++;
        }   
    }
}