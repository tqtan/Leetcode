    # O(n)  O(l)
    # 设置两个指针，从前到后分别读取奇偶两个节点，螺旋式排链？
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        ListNode p = p2;
        while (p1.next != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = p;
        return head;
    }
