    # 法一：优先级队列  O(Nlogk)
    # 将每个表头存入优先级队列，自定义优先级规则，每次poll出最小的结点，将该结点的下一结点作为新表头添加进队列
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                if (l1.val < l2.val) return -1;
                else if (l1.val > l2.val) return 1;
                else return 0;
            }
        });
        
        for (ListNode node : lists){
            if (node != null) queue.add(node);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) queue.add(cur.next);
        }
        return dummyHead.next;
    }
    # 法二：分治+递归 O(Nlongk)      O(k)
		# 思路：每次合并两个链表，下次再合并上轮新生成的两个链表，即链表条数：k/2->k/4->k/8->…->1，合并了logk次，每次基本访问了所有结点N
    # 步骤：lists链表成对递归merge、两个链表所有结点比较mergeTwoLists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists,0,lists.length-1);
    }
    
    public ListNode merge(ListNode[] lists, int left, int right){
        if (left == right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return mergeTwoLists(l1,l2);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
