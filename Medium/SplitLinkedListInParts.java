
import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SplitLinkedListInParts {

    public static ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] result = new ListNode[k];

        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int partSize = length / k;
        int extra = length % k;

        curr = head;

        for (int i = 0; i < k; i++) {

            if (curr == null) {
                result[i] = null;
                continue;
            }

            result[i] = curr;

            int currentSize = partSize + (extra > 0 ? 1 : 0);

            if (extra > 0)
                extra--;

            for (int j = 1; j < currentSize; j++) {
                curr = curr.next;
            }

            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return result;
    }

    static void printList(ListNode head) {

        System.out.print("[");

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null)
                System.out.print(", ");

            head = head.next;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        ListNode curr = head;

        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        int k = 3;

        ListNode[] ans = splitListToParts(head, k);

        for (int i = 0; i < ans.length; i++) {

            System.out.print("Part " + (i + 1) + ": ");

            if (ans[i] == null)
                System.out.println("[]");
            else
                printList(ans[i]);
        }
    }
}