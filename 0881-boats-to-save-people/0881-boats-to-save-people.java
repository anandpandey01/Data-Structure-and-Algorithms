class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i=0, j= n-1;
        int minboats =0;
        while(i<=j){
            if(people[i]+people[j]<=limit){     // Max of 2 people
                minboats++;
                i++; j--;
            }
            else if(people[j]<= limit){
                minboats++;
                j--;
            }
            else if(people[i]<= limit){
                minboats++;
                i++;
            }
        }
        return minboats;
    }
}