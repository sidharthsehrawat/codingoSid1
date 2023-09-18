package folder.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArraysPriorityQueue {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3, 7, 11, 13, 2, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 4, 9);
        List<Integer> list3 = Arrays.asList(5, 10, 12, 14);
        int k = 3;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

       /* for(int i=0;i<list1.size();i++){
            priorityQueue.add(list1.get(i));
        }
        priorityQueue.remove();
        priorityQueue.poll();*/

    }
}
