package revision.linkedlist;

import folder.LL.AddTwoLLAsSum;

public class RotateLinkedList {
    static class ListNode {
        ListNode next;
        int val;
        public ListNode(int val ){
            this.val = val;
        }
    }

    private static ListNode insertAtEnd(int val, ListNode head) {
        if (head == null) {
            ListNode newNode = new ListNode(val);
            head = newNode;
            return head;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            ListNode newNode = new ListNode(val);
            current.next = newNode;

        }
        return head;
    }

    private static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = insertAtEnd(1, null);
        ListNode second = insertAtEnd(2, head);
        ListNode third = insertAtEnd(3, second);
        ListNode fourth = insertAtEnd(4, third);
        ListNode fifth = insertAtEnd(5, fourth);
        display(head);
        ListNode ans = rotateRight(head, 2);
        System.out.println("ans");
        display(ans);
        
    }

    public static ListNode rotateRight(ListNode head, int k) {
        // p
        // 1 -> 2 -> 3 -> Null
        //                4 -> 5
        //  n
        ListNode p = head;
        int count = 1;
        while(count < k+1){
            p = p.next;
            count++;
        }

        ListNode newNode= p.next;
        ListNode finalHead = newNode;
        p.next = null;

        while(newNode.next!=null) {
            newNode = newNode.next;
        }

        newNode.next = head;

        return finalHead;

    }

}
