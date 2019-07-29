    # 二叉树层次遍历 O(n)  O(n)
    # 因输出列表分层输出，添加计数当前queue.size()
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int nums = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }
