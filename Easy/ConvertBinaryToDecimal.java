
public class ConvertBinaryToDecimal {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int getDecimalValue(ListNode head) {

        int num = 0;

        while (head != null) {
            num = num * 2 + head.val;
            head = head.next;
        }

        return num;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(getDecimalValue(head));
    }
}