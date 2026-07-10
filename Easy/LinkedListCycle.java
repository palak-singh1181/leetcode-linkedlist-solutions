
/*
LeetCode 141
Linked List Cycle

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        LinkedListCycle obj = new LinkedListCycle();

        // Example 1: Cycle exists
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);

        // Create cycle
        head1.next.next.next.next = head1.next;

        System.out.println(obj.hasCycle(head1)); // true

        // Example 2: No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println(obj.hasCycle(head2)); // false
    }
}