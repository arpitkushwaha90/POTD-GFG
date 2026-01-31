class kQueues {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;
    int n;
    int k;
    
    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        this.arr = new int[n];
        this.front = new int[k];
        this.rear = new int[k];
        this.next = new int[n];
        
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }
        
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }
    
    void enqueue(int x, int i) {
        if (free == -1) {
            return;
        }
        
        int nextFree = next[free];
        
        if (front[i] == -1) {
            front[i] = free;
        } else {
            next[rear[i]] = free;
        }
        
        rear[i] = free;
        next[free] = -1;
        arr[free] = x;
        free = nextFree;
    }
    
    int dequeue(int i) {
        if (front[i] == -1) {
            return -1;
        }
        
        int frontIndex = front[i];
        int value = arr[frontIndex];
        
        front[i] = next[frontIndex];
        
        if (front[i] == -1) {
            rear[i] = -1;
        }
        
        next[frontIndex] = free;
        free = frontIndex;
        
        return value;
    }
    
    boolean isEmpty(int i) {
        return front[i] == -1;
    }
    
    boolean isFull() {
        return free == -1;
    }
}
