package LinkedList;

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class sortLinkedList {

  public ListNode sortList(ListNode head) {
    ListNode newnode = new ListNode();
    newnode.next = head;
    mergeSort(head);
    return newnode.next;
  }

  private static ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode mid = findMid(head);
    ListNode head2 = mid.next;
    mid.next = null;
    ListNode newhead1 = mergeSort(head);
    ListNode newhead2 = mergeSort(head2);
    return sort(newhead1, newhead2);
  }

  private static ListNode findMid(ListNode node) {
    ListNode slow = node;
    ListNode fast = node;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private static ListNode sort(ListNode a, ListNode b) {
    ListNode temp1 = new ListNode(0);
    ListNode temp = temp1;
    while (a != null && b != null) {
      if (a.val < b.val) {
        temp1.next = a;
        temp1 = temp1.next;
        a = a.next;
      } else {
        temp1.next = b;
        temp1 = temp1.next;
        b = b.next;
      }
    }
    if (a != null) {
      temp1.next = a;
    } else temp1.next = b;

    return temp.next;
  }
}
