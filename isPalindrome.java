    # O（n）
    # 先快慢指针找出中点，反转后半截链表（以slow.next开始），从前往后+从后往前两个方向判断是否是回文
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode next = null;
        slow = slow.next;
        while (slow != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        slow = pre;
        while (slow != null){
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
