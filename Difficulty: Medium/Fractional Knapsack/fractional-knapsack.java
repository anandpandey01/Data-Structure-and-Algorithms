class Solution {
    class Items{
        int value;
        int weight;
        Items(int value,int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = weights.length;
        Items[] item = new Items[n];
        for(int i=0; i<n; i++){
            item[i] = new Items(values[i],weights[i]);
        }
        Arrays.sort(item, (a,b)-> Double.compare((double)b.value/b.weight,(double)a.value/a.weight));
        // Note the casting must be done before division
        
        double result=0;
        for(int i=0; i<n; i++){
            if(W>=item[i].weight){
                W-=item[i].weight;
                result+=item[i].value;  
            }
            else{
                result+=W*((double)item[i].value/item[i].weight); break;
                //Note the brackets
            }
        }
        return result;
    }
}