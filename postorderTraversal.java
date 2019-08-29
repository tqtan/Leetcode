    # 法一：模仿前序遍历(根-左-右)，交换左后孩子入栈顺序变为（根-右-左），利用LinkedList.addFirst倒序读入（左-右-根）
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> S = new Stack<>();
        TreeNode cur = root;
        S.push(cur);
        while (!S.isEmpty()){
            cur = S.pop();
            res.addFirst(cur.val);
            if (cur.left != null) S.push(cur.left);
            if (cur.right != null) S.push(cur.right);
        }
        return res;
    }
