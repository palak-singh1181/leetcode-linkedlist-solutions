
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }
}

public class DoubleANumberRepresentedAsLinkedList {

    public static ListNode doubleIt(ListNode head) {

        head = reverse(head);

        int carry = 0;
        ListNode curr = head;

        while (curr != null) {

            int sum = curr.val * 2 + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
                break;
            }

            curr = curr.next;
        }

        return reverse(head);
    }

    private static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);

        System.out.print("Original: ");
        printList(head);

        head = doubleIt(head);

        System.out.print("Doubled : ");
        printList(head);
    }
}