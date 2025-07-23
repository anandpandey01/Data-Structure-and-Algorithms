class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        long sumN = (long) n * (n + 1) / 2;
        long sumSqN = (long) n * (n + 1) * (2 * n + 1) / 6;

        long sum = 0, sumSq = 0;
        for (int num : arr) {
            sum += num;
            sumSq += (long) num * num;
        }

        long diff = sum - sumN;            // repeating - missing
        long sqDiff = sumSq - sumSqN;      // repeating^2 - missing^2

        long sumOfNums = sqDiff / diff;    // repeating + missing

        int repeating = (int) ((diff + sumOfNums) / 2);
        int missing = (int) (repeating - diff);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
