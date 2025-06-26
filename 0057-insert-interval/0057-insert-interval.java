class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            temp.add(intervals[i]);
        }
        temp.add(newInterval);
        temp.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(temp.get(0));

        for (int i = 1; i < temp.size(); i++) {
            int currStart = temp.get(i)[0], currEnd = temp.get(i)[1];
            int[] prev = result.get(result.size() - 1);
            if (prev[1] >= currStart) {
                prev[1] = Math.max(prev[1], currEnd);
            } else {
                result.add(new int[] { currStart, currEnd });
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}