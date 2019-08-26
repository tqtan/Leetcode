    # 镜面对称二叉树
    # 法一：非递归 队列两个结点的左右子树交叉入队
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        Q.add(root);
        while (!Q.isEmpty()){
            TreeNode q1 = Q.poll();
            TreeNode q2 = Q.poll();
            if (q1 == null && q2 == null) continue;
            if (q1 == null || q2 == null) return false;
            if (q1.val != q2.val) return false;
            Q.add(q1.left);
            Q.add(q2.right);
            Q.add(q1.right);
            Q.add(q2.left);           
        }
        return true;
    }
    
    # 法二：递归 当前两结点值相等，递归代入结点1左孩子+结点2右孩子，结点1右孩子+结点2左孩子
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
