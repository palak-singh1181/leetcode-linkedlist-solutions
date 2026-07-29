class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

public class FlattenMultilevelDoublyLinkedList {

    public static Node flatten(Node head) {
        if (head == null) return null;

        dfs(head);
        return head;
    }

    private static Node dfs(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = dfs(childHead);

                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
                curr = childTail;
            } else {
                last = curr;
            }

            curr = curr.next;
        }

        return last;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 1-2-3-4
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;

        // child: 3 -> 7 -> 8
        Node c1 = new Node(7);
        Node c2 = new Node(8);

        c1.next = c2;
        c2.prev = c1;

        n3.child = c1;

        Node head = flatten(n1);

        System.out.println("Flattened List:");
        printList(head);
    }
}