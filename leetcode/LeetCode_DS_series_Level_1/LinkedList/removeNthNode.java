package LinkedList;

public class removeNthNode {

    public static void main(String[] args) {
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode walker = head;
        ListNode runner = head;

        int index = 0;
        while (index < n) {
            runner = runner.next;
            index++;
        }
        while (runner != null && runner.next != null) {
            runner = runner.next;
            walker = walker.next;
        }
        if (walker.next != null && runner != null)
            walker.next = walker.next.next;
        else
            head = head.next;
        return head;
    }
}
