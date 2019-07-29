# 删除倒数第n个结点   O(n)
# 快慢双指针：快指针一开始就比慢指针多走n+1步，后同步前进，当快指针走完时，慢指针刚好在待删除结点的前一结点
public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;
        for (int i = 0; i < n + 1; i++)
            fast = fast.next;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
