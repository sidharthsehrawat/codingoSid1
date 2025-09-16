package folder.design_patterns.LFU;

import java.util.*;

public class LFUCache {
    private final int CACHE_SIZE;

    // 1. key -> value
    private Map<Integer, Integer> keyValue;

    // 2. key -> frequency count
    private Map<Integer, Integer> keyFrequency;

    // 3. frequency -> keys with that frequency
    private Map<Integer, LinkedHashSet<Integer>> freqKeys;

    // Track the minimum frequency in the cache
    private int minFreq;

    public LFUCache(int capacity) {
        this.CACHE_SIZE = capacity;
        this.keyValue = new HashMap<>();
        this.keyFrequency = new HashMap<>();
        this.freqKeys = new HashMap<>();
        this.minFreq = 0;
    }

    // ------------------- GET -------------------
    public Integer get(int key) {
        if (!keyValue.containsKey(key)) {
            return -1; // not found
        }

        // Get old frequency
        int oldFreq = keyFrequency.get(key);
        int newFreq = oldFreq + 1;

        // Update frequency map
        keyFrequency.put(key, newFreq);

        // Remove key from old frequency bucket
        LinkedHashSet<Integer> oldSet = freqKeys.get(oldFreq);
        oldSet.remove(key);

        // If old set becomes empty, remove it
        if (oldSet.isEmpty()) {
            freqKeys.remove(oldFreq);

            // If oldFreq was the minFreq, increase minFreq
            if (oldFreq == minFreq) {
                minFreq = newFreq;
            }
        }

        // Add key into new frequency bucket
        LinkedHashSet<Integer> newSet = freqKeys.get(newFreq);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqKeys.put(newFreq, newSet);
        }
        newSet.add(key);

        // Return the value
        return keyValue.get(key);
    }

    // ------------------- PUT -------------------
    public void put(int key, int value) {
        if (CACHE_SIZE == 0) return;

        // Case 1: Key already exists -> update value + increase frequency
        if (keyValue.containsKey(key)) {
            keyValue.put(key, value); // update value
            get(key); // update frequency using get()
            return;
        }

        // Case 2: Cache is full -> need to evict LFU key
        if (keyValue.size() == CACHE_SIZE) {
            LinkedHashSet<Integer> minFreqSet = freqKeys.get(minFreq);
            int evictKey = minFreqSet.iterator().next(); // oldest in minFreq
            minFreqSet.remove(evictKey);

            if (minFreqSet.isEmpty()) {
                freqKeys.remove(minFreq);
            }

            keyValue.remove(evictKey);
            keyFrequency.remove(evictKey);

            System.out.println("Evicted: " + evictKey + " (freq=" + minFreq + ")");
        }

        // Insert the new key
        keyValue.put(key, value);
        keyFrequency.put(key, 1);

        LinkedHashSet<Integer> set = freqKeys.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqKeys.put(1, set);
        }
        set.add(key);

        // Reset minFreq to 1 because new key starts with freq=1
        minFreq = 1;
    }

    // ------------------- DISPLAY -------------------
    public void display() {
        System.out.println("Cache contents:");
        for (int key : keyValue.keySet()) {
            System.out.println("Key=" + key + ", Value=" + keyValue.get(key) +
                    ", Freq=" + keyFrequency.get(key));
        }
    }

    // ------------------- MAIN -------------------
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);

        lfu.put(1, 10);
        lfu.put(2, 20);
        lfu.put(3, 30);

        lfu.get(1); // freq(1)=2
        lfu.get(1); // freq(1)=3
        lfu.get(2); // freq(2)=2

        lfu.put(4, 40); // evicts key=3 (freq=1, lowest)

        lfu.display();
    }
}
