import java.util.ArrayList;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListRandomNode {

    private ArrayList<Integer> list;
    private Random random;

    public LinkedListRandomNode(ListNode head) {

        list = new ArrayList<>();
        random = new Random();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        LinkedListRandomNode obj = new LinkedListRandomNode(head);

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}