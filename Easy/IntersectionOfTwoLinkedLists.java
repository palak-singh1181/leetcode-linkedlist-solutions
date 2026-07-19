public class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {

        // Common Part
        ListNode common1 = new ListNode(8);
        ListNode common2 = new ListNode(4);
        ListNode common3 = new ListNode(5);

        common1.next = common2;
        common2.next = common3;

        // List A : 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common1;

        // List B : 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common1;

        ListNode ans = getIntersectionNode(headA, headB);

        if (ans != null)
            System.out.println("Intersection Node = " + ans.val);
        else
            System.out.println("No Intersection");
    }
}
