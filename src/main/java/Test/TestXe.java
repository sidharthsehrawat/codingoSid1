package Test;

import java.util.HashMap;
import java.util.Map;

public class TestXe {
    private static ListNode tail;

    static class ListNode {
        int data;
        ListNode next;
        ListNode last;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String str1 = "ababb c aa c b k";
        int k1 = 3;
        int start = 0;
        int end = 0;

        Map<Character, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!mapCount.containsKey(ch)) {
                mapCount.put(ch, 1);
            } else {
                mapCount.put(ch, mapCount.get(ch) + 1);
            }
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (mapCount.get(ch) < k1) {
                for (int k = start; k <= i - 1; k++) {
                    char ch1 = str1.charAt(k);
                    if (mapCount.get(ch1) >= k1) {
                        count++;
                    } else {
                        max = Math.max(max, count);
                        count = 0;
                    }
                }
                start = i;
            }
        }

        /*ListNode head = enque(10, null);
        ListNode second = enque(20,head);
        ListNode third = enque(30,second);
        ListNode newHead =deque(head);
        ListNode fouth = enque(40,newHead);
        ListNode fifth = enque(50,fouth);
        ListNode newHead1 =deque(fifth);
        displayList(newHead1);
    }
    private static void displayList(ListNode head) {
        ListNode current  = head;
        while(current!=null){
            System.out.println(current.data + "-->" );
            current= current.next;
        }
    }
    // h   t
// 10 20  30
    private static ListNode deque(ListNode head) {
        ListNode current = head;
        head= current.next;
        current.next = null;
        return head;
    }
    private static ListNode enque(int data, ListNode head) {
        if(head == null){
            ListNode newNode = new ListNode(data);
            head= newNode;
            tail= newNode;
        }else {
            ListNode node  = new ListNode(data);
            tail.next = node;
            tail = node;
        }
        return head;
    }
*/
    }
}
