    # O（n）找到新的链头、链尾，原链尾连接原链尾，新链尾断开，返回新链头；
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        ListNode pre = head, last = head;
        while (last.next != null){
            len++;
            last = last.next;
        }
        int n = k % len;
        if (n == 0) return head;
        for (int i = 0; i < len - n - 1; i++) pre = pre.next;
        last.next = head;
        ListNode newhead = pre.next;
        pre.next = null;
        return newhead; 
    }
