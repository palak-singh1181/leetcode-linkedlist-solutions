public class MergeInBetweenLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode prevA = list1;

        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        ListNode afterB = prevA;

        for (int i = 0; i < b - a + 2; i++) {
            afterB = afterB.next;
        }

        prevA.next = list2;

        ListNode tail = list2;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = afterB;

        return list1;
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // list1 = [10,1,13,6,9,5]
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(13);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(5);

        // list2 = [1000000,1000001,1000002]
        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);

        int a = 3;
        int b = 4;

        ListNode result = mergeInBetween(list1, a, b, list2);

        printList(result);
    }
}
