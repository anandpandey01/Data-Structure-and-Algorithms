class Solution {
    class Items{
        int value,weight;
        Items(int value,int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n = values.length;
        Items[] arr = new Items[n];
        for(int i=0; i<n; i++){
            arr[i] = new Items(values[i], weights[i]);
        }
        double maxVal = 0;
        Arrays.sort(arr, (a,b)-> Double.compare((double)b.value/b.weight ,(double)a.value/a.weight));
        for(int i=0; i<n; i++){
            if(W>=arr[i].weight){
                W-=arr[i].weight;
                maxVal+=arr[i].value;
            }
            else{
                maxVal+= W *((double) arr[i].value / arr[i].weight);  //Note the brackets
                break;
            }
        }
        return maxVal;
    }
}