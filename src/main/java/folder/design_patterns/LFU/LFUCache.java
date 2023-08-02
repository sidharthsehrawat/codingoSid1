package folder.design_patterns.LFU;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    int CACHE_SIZE;
    LinkedHashSet<Integer> linkedHashSet;
    Map<Integer, Integer> search;
    Map<Integer, LinkedHashSet<Integer>> LFUMAP;

    public LFUCache(int size) {
        this.CACHE_SIZE = size;
        linkedHashSet = new LinkedHashSet<>(size);
        LFUMAP = new HashMap<>();
        search = new HashMap<>();
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.insert(1);
        lfuCache.insert(2);
        lfuCache.insert(3);
        lfuCache.insert(4);
        lfuCache.insert(5);
        lfuCache.get(2);
        lfuCache.insert(6);
    }

    private void get(int data) {
    }

    private void insert(int data) {       //   1
        if (!search.containsKey(data)) {
             search.put(data,1);
             insertIntoLFU(data);
             //LFUMAP.put(data)
        }else{

        }
    }

    private void insertIntoLFU(int data) {
        if()
    }

}
