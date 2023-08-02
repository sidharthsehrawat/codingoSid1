package folder.LL;

import java.util.List;

public class AddTwoLLAsSum {
    static class ListNode {
        ListNode next;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
    }


    /* TODO
     * incomplete
     * */

    private static ListNode insertAtEnd(int data, ListNode head) {
        if (head == null) {
            ListNode newNode = new ListNode(data);
            head = newNode;
            return head;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            ListNode newNode = new ListNode(data);
            current.next = newNode;

        }
        return head;
    }

    public static void main(String[] args) {

        int num = 5;
        int rem = num % 10;
        ListNode head = insertAtEnd(2, null);
        ListNode second = insertAtEnd(4, head);
        ListNode third = insertAtEnd(3, second);

        display(head);

        System.out.println();
        ListNode head1 = insertAtEnd(5, null);
        ListNode second1 = insertAtEnd(6, head1);
        ListNode third1 = insertAtEnd(4, second1);
        display(head1);

        ListNode ansHead = getAddition(head, head1);
        System.out.println();
        display(ansHead);


        //    "123"
        //    "456"
        //    ------
        //     580


    }

    //   2 2
    //   9 0
    //  --------
    //  1->5
    private static ListNode getAddition(ListNode head, ListNode head1) {
        int size1 = sizeLL(head);
        int size2 = sizeLL(head1);
        int diff = 0;
        if (size1 > size2) {
            diff = size1 - size2;
            for (int i = 0; i < diff; i++) {
                ListNode current = head1;
                while (current.next != null) {
                    current = current.next;
                }
                ListNode newNodw = new ListNode(0);
                current.next = newNodw;
                newNodw.next = null;
            }
        } else {
            diff = size2 - size1;
            for (int i = 0; i < diff; i++) {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                ListNode newNodw = new ListNode(0);
                current.next = newNodw;
                newNodw.next = null;
            }
        }
        //     2 2
        //     9 0
        // int len = sizeLL(head1);

        ListNode current = head;
        ListNode current1 = head1;
        ListNode newHead = null;
        int sum = 0;
        int carry = 0;
       // 2 4 3
       // 5 6 4
        while (current != null && current1 != null) {
            sum = current.data + current1.data;
            if (carry > 0) {
                sum = sum + carry;
                carry =0;
            }
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            if (newHead == null) {
                newHead = new ListNode(sum);
            } else {
                ListNode currentNew = newHead;
                while (currentNew.next != null) {
                    currentNew = currentNew.next;
                }
                ListNode newNode = new ListNode(sum);
                currentNew.next = newNode;
            }
            current = current.next;
            current1 = current1.next;
        }

        if (carry > 0) {
            ListNode curr = newHead;
            while (curr.next != null) {
                curr = curr.next;
            }
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
            newNode.next = null;
        }
        return newHead;
    }

    private static int sizeLL(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}
