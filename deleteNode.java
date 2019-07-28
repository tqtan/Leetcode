# 删除链表中的节点 O(l)
# 只给了要删除的结点，不能用常规前驱结点指向下一结点的方法
# 直接将下一结点值覆盖被删除结点，被删除结点指向下下结点，相当于复制为下一结点+删除下一结点
public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
