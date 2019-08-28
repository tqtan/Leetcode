    # 查找环形链表的相交点
    # 法一：遍历链表hashmap保存，若出现过则返回该结点 O(n) O(n)
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null){
            if (map.containsKey(cur)) return cur;
            map.put(cur,0);
            cur = cur.next;
        }
        return null;
    }
    
    # 法二：快慢指针第一次相遇的点和头结点同时出发会在相交点相遇  O(n)  O(l)
    # 快慢指针初始化同时从head开始！！
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast != slow) return null;
        ListNode cur = head;
        while (cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
