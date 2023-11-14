package folder.streams;

import java.util.*;

class Pair {
    int start ;
    int end;

    public Pair(int start , int end){
        this.end = end;
        this.start= start;

    }
}
public class SortPairINPQ {
    public static void main(String[] args) {
        // (1-3)(4-6)(2-5)
        Pair p1=  new Pair(1,3);
        Pair p2=  new Pair(4,6);
        Pair p3=  new Pair(2,5);
        List<Pair> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        Collections.sort(list, new Comparator<Pair>() {

            public int compare(Pair o1, Pair o2) {
               if(o1.start > o2.start){
                   return 1;
               }else if(o1.start < o2.start){
                   return -1;
               }else {
                   return 0;
               }
            }
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
           if(o1.start > o2.start){
               return 1;
           }else if(o1.start < o2.start){
               return -1;
           }else return 0;
        });
        pq.offer(p1);
        pq.offer(p2);
        pq.offer(p3);
        pq.poll();
        pq.poll();

    }
}
