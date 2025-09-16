package folder.design_patterns.LRU;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRU_LinkedHashSet {
    int CACHE_SIZE;
    LinkedHashSet<Integer> linkedHashSet;

    public LRU_LinkedHashSet(int size) {
        this.CACHE_SIZE = size;
        linkedHashSet = new LinkedHashSet<Integer>(size);
    }

    private void refer(int data) {
        if (!linkedHashSet.contains(data)) {
            if (linkedHashSet.size() < CACHE_SIZE) {
                linkedHashSet.add(data);   // 5 4 3     | 2  1
            }else{
               int data1 =  linkedHashSet.iterator().next();
               linkedHashSet.remove(data1);
               linkedHashSet.add(data);
            }
        }else { // already present in cache
            linkedHashSet.remove(data);
            linkedHashSet.add(data);
        }
    }

    private void display() {
        LinkedList<Integer> list = new LinkedList<>(linkedHashSet);
        Iterator<Integer> itr = list.descendingIterator();
        while (itr.hasNext()){
            System.out.print(" " + itr.next());
        }
    }


    public static void main(String[] args) {
        LRU_LinkedHashSet obj = new LRU_LinkedHashSet(3);
        obj.refer(1);
        obj.refer(2);
        obj.refer(3);
        obj.refer(4);
        obj.refer(5);
        obj.display();
    }


}
