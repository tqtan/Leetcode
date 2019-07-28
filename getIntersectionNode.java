    # 相交链表 O(m+n)
    # 双指针法
    # 从前往后遍历A、B链表，若next==null则将A尾结点后的null连接到B表头，B连接到A表头；若有相交则返回相交值，否则将会在第二轮同时返回null
    # 注：假设两链表后c位数相同，即A=a+c，B=b+c；循环相遇即a+c+b=b+c+a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb){
            ha = ha == null? headB:ha.next;
            hb = hb == null? headA:hb.next;
        }
        return ha;
    }
