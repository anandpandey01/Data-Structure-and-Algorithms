// User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int n, int arr[]) {
        // code here
        for (int i = (n-1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }
    
    static void heapify(int[] arr, int index, int n) {
      int largest = index;
      int left = index * 2 + 1;
      int right = index * 2 + 2;
      if (left < n && arr[left] > arr[largest]) {
          largest = left;
      }
      if (right < n && arr[right] > arr[largest]) {
          largest = right;
      }
      if (index != largest) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
      }
  }
}
