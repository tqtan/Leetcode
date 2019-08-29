    # 非递归实现：出栈-访问-右孩子非空入栈-左孩子非空入栈
  
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();
        TreeNode cur = root;
        S.push(cur);
        while (!S.isEmpty()){
            cur = S.pop();
            res.add(cur.val);
            if (cur.right != null) S.push(cur.right);
            if (cur.left != null) S.push(cur.left);
        }
        
#        while (!S.isEmpty()){
#            cur = S.pop();
#            res.add(cur.val);
#            while (cur != null){
#                if (cur.left != null) res.add(cur.left.val);
#                if (cur.right != null) S.push(cur.right);
#                cur = cur.left;
#            }
#        }
        return res;
    }
