    # 二叉搜索树中第K小的元素 O(n)
    # 中根遍历即为排序序列，利用两个全局变量，count计数倒计时赋值，res确定是否提前中止遍历
    int count,res = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return res;
    }
    public void inorderTraversal(TreeNode root){
        if (root != null){
            inorderTraversal(root.left);
            if (res != Integer.MAX_VALUE) return;
            if (--count == 0) res=root.val;
            inorderTraversal(root.right); 
        }  
    }
