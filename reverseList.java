    # 反转链表  O(n)
    # 法一：迭代
    # 涉及前一结点、当前结点，每次循环修改当前结点的后继指针，暂时存储下一结点——>当前指向前一结点——>前一结点后移——>当前结点后移
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextnode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextnode;
        }
        return pre;
    }
    
    # 法二：递归
    # p始终保存当前已反转链表的表头，关键：head.next.next = head
    public ListNode reverseList(ListNode head) { 
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
