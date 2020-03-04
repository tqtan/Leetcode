  # 指针：pre翻转前一位置，start翻转起始位置，curp最终为翻转尾部，cur最终为翻转位置后的结点
  # pre—>curp   start—>cur
  public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int num = n - m;
        for (int i = 0; i < m-1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode curp = start;
        ListNode cur = curp.next;
        ListNode next = null;
        while (num > 0){
            next = cur.next;
            cur.next = curp;
            curp = cur;
            cur = next;
            num--;
        }
        pre.next = curp;
        start.next = cur;
        return dummy.next;

    }
