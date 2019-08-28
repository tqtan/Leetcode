# O(n) 两个指针，前指针判断是否=val，直至不等于时用第二个指针next
public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = pre.next;
        while (cur != null){
            cur = pre.next;
            while (cur != null && cur.val == val) cur = cur.next;
            pre.next = cur;
            pre = pre.next;
        }
        return dummyHead.next;
    }
