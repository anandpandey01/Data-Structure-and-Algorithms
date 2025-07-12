class Solution {  //Using Two Pointers
    public String reverseWords(String s) {
        // Code here
       char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int n = arr.length;
        int i = 0, l = 0, r = 0;

        while (i < n) {
            while (i < n && arr[i] == ' ') i++;   // Skip multiple spaces
            while (i < n && arr[i] != ' ') {      // Copy non-space characters forward
                arr[r++] = arr[i++];
            }
            if (l < r) {                          // Reverse the word
                reverse(arr, l, r - 1);
                if (r < n) arr[r++] = ' ';
                l = r;
            }
        }
        if (r > 0 && arr[r - 1] == ' ') r--;     // Remove trailing space if present
        return new String(arr, 0, r);
    }
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }
}
