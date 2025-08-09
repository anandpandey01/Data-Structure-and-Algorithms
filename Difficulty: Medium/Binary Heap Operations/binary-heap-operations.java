class MinHeap {
    int[] arr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        arr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return (2 * i + 1); }

    int right(int i) { return (2 * i + 2); }

    // Function to extract minimum value in heap and then to store
    // next minimum value at first index.
    int extractMin() {
        // Your code here.
        // Swap Last item with the root
        if(heap_size == 0) return -1;
        if(heap_size == 1) {heap_size--; return arr[0];}
        int temp = arr[0];
        arr[0] = arr[heap_size-1];
        arr[heap_size-1] = temp;
        heap_size--;
        MinHeapify(0);
        return arr[heap_size];   // The element we swapped and removed, not part of heap
        
    }

    // Function to insert a value in Heap.
    void insertKey(int k) {
        // Your code here.
        // if(heap_size == capacity) return false
        heap_size++;
        arr[heap_size-1] = k;
        
        int i = heap_size -1;
        while(i > 0 && arr[parent(i)] > arr[i] ){   // If reaches root then also stop
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);    // Note
        }
        
    }

    // Function to delete a key at ith index.
    void deleteKey(int i) {
        // Your code here.
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) {
        arr[i] = new_val;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && arr[l] < arr[i]) smallest = l;
        if (r < heap_size && arr[r] < arr[smallest]) smallest = r;  // Finding the minimum of root left and right
        if (smallest != i) {       // Check Its not root
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}