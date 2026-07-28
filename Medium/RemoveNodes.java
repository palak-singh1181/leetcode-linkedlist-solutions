public class RemoveNodes {


    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode removeNodes(ListNode head) {

        head = reverse(head);

        int max = head.val;

        ListNode curr = head;


        while (curr != null && curr.next != null) {


            if (curr.next.val < max) {

                curr.next = curr.next.next;

            } else {

                curr = curr.next;
                max = curr.val;
            }
        }


        return reverse(head);
    }



    public static ListNode reverse(ListNode head) {

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



    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }
    }



    public static void main(String[] args) {


        ListNode head = new ListNode(5);

        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);


        head = removeNodes(head);


        printList(head);

    }
}