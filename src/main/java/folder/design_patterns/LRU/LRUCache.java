package folder.design_patterns.LRU;

import java.util.*;

public class LRUCache {
    int CACHE_SIZE;
    HashSet<Integer> search;
    Deque<Integer> deque;


    public LRUCache(int cache) {
        this.CACHE_SIZE = cache;
        search = new HashSet<>();
        deque = new LinkedList<>();
    }


    private void display() {
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }

    private void insert(int data) {  // 4 3 2    1
        if (!search.contains(data)) {
            if (deque.size() < CACHE_SIZE) {
                deque.push(data);
                search.add(data);
            } else {
                int last = deque.removeLast();
                search.remove(last);
                deque.push(data);
            }
        } else {
            deque.remove(data);
            deque.push(data);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.insert(1);
        lruCache.insert(2);
        lruCache.insert(3);
        lruCache.insert(6);

        lruCache.insert(5);
        lruCache.display();
    }
} //    5 4 3
