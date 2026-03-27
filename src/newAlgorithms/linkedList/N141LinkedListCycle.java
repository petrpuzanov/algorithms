package newAlgorithms.linkedList;

public class N141LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // +1 шаг
            fast = fast.next.next;     // +2 шага

            if (slow == fast) {
                return true; // встретились → цикл
            }
        }

        return false; // дошли до null → цикла нет
    }
}
