    # O（n）
    # 两个指针，一个状态b：pre不重复的最后一个结点，cur当前结点需判断后面有无重复，有则b=true，无则让cur加入当前pre
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        boolean b = false;
        while (cur != null){
            while (cur.next != null && cur.next.val == cur.val){
                b = true;
                cur.next = cur.next.next;
            }
            if (b == false){
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
            b = false;
        }
        pre.next = cur;
        return dummy.next;
    }
