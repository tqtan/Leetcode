    # 二叉树中根遍历
    # 法一：递归 O(n) O(logn)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }
    
    public void traversal(TreeNode root, List res){
        if (root != null){
            traversal(root.left,res);
            res.add(root.val);
            traversal(root.right,res);
        }
    }
    
    # 法二：迭代 O(n)  O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !S.isEmpty()){
            while (cur != null){
                S.push(cur);
                cur = cur.left;
            }
            cur = S.pop();
            res.add(cur.val);
            cur = cur.right;               
        }
        return res;
    }
