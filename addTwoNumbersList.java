    # 两数相加 O(max(m,n))
    # 虚拟表头用于返回表头
    # 判断l1、l2是否存在，若!=null则+val且=next
    # 用标记参数判断该位是否>=10，循环结束后判断最后一位数是否>=10
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int moreten = 0;
        while (l1 != null || l2 != null){
            cur.next = new ListNode(moreten);
            if (l1 != null){
                cur.next.val = cur.next.val + l1.val;
                l1 = l1.next;
            }
            if (l2 !=null){
                cur.next.val = cur.next.val + l2.val;
                l2 = l2.next;
            }
            if (cur.next.val >= 10){
                moreten = 1;
                cur.next.val = cur.next.val - 10;
            }else
                moreten = 0;
            cur = cur.next;
        }
        
        if (moreten == 1) cur.next = new ListNode(1);
        
        return dummyHead.next;
    }
