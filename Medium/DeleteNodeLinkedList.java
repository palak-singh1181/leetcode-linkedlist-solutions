
// LeetCode 237
// Delete Node in a Linked List

class ListNode {

    int val;
    ListNode next;


    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


public class DeleteNodeLinkedList {


    public static void deleteNode(ListNode node) {

        // Copy next node value
        node.val = node.next.val;


        // Remove next node
        node.next = node.next.next;
    }



    // Print Linked List
    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }
    }



    public static void main(String[] args) {


        // Creating Linked List
        // 4 -> 5 -> 1 -> 9

        ListNode head = new ListNode(4);

        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);



        // Node to delete (5)
        ListNode node = head.next;



        deleteNode(node);



        // Output: 4 1 9
        printList(head);
    }
}