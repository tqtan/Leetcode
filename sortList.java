    # 链表排序  O(nlogn)
    # 1.二路归并    2.断链，快慢双指针法找链表中点    3.虚拟/辅助头结点dummyHead
    # 注：避免2结点情况出错，初始化fast=head.next；奇数为中点，偶数为中点左结点
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;           
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left,right);
    }
    
    public ListNode merge(ListNode l, ListNode r){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null){
            if (l.val <= r.val){
                cur.next = l;
                l = l.next;
            }else{
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null) cur.next = l;
        if (r != null) cur.next = r;
        return dummyHead.next;
    }
