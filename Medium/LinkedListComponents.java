import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListComponents {

    public static int numComponents(ListNode head, int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        int count = 0;

        while (head != null) {

            if (set.contains(head.val) &&
                (head.next == null || !set.contains(head.next.val))) {

                count++;
            }

            head = head.next;
        }

        return count;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        int[] nums = {0, 1, 3};

        System.out.println(numComponents(head, nums));
    }
}