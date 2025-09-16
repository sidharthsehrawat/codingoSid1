package folder.design_patterns.LRU;


import java.util.*;

public class LRUCache1 {
    int CACHE_SIZE;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache1(final int capacity) {
        this.CACHE_SIZE = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity; // use constructor param
            }
        };
    }

    public void insert(int key, int value) {
        map.put(key, value); // automatically moves to most recent
    }

    public Integer get(int key) {
        if (map.containsKey(key)) {
            return map.get(key); // also moves key to most recently used
        } else {
            return -1;
        }
    }
    public void display() {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(3);

        cache.insert(1, 10);
        cache.insert(2, 20);
        cache.insert(3, 30);
        cache.display(); // 1=10 2=20 3=30

        cache.get(1);   // access key 1 → makes it most recent
        cache.insert(4, 40); // evicts 2
        cache.display(); // 3=30 1=10 4=40

        cache.insert(5, 50); // evicts 3
        cache.display(); // 1=10 4=40 5=50
    }
}
