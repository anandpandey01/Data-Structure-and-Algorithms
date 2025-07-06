class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        int timer=0;
        while(true){
            timer++;
            int trips=0;
            for(int i=0; i<n; i++){
                trips+= timer/time[i];
            }
            if(trips >= totalTrips){
                break;
            }
        }
        return timer;
    }
}