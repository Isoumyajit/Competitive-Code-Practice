
import java.util.PriorityQueue;

public class mergeKsortedList {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Pair> helper = new PriorityQueue<>();

        ListNode head = new ListNode();
        ListNode temp = head;
        for (int index = 0; index < lists.length; index++) {
            if (lists[index] != null) {
                helper.add(new Pair(lists[index]));
            }
        }
        while (!helper.isEmpty()) {
            ListNode dummy = helper.poll().node;
            if (dummy != null && dummy.next != null)
                helper.add(new Pair(dummy.next));
            if (head == null) {
                head = dummy;
                temp = head;
            } else {
                temp.next = dummy;
                temp = temp.next;
            }
        }
        return head.next;
    }

    class Pair implements Comparable<Pair> {
        ListNode node;
        int data;

        Pair(ListNode node) {
            this.node = node;
            if (node != null)
                this.data = node.val;
        }

        @Override
        public int compareTo(Pair a) {
            return this.data - a.data;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
