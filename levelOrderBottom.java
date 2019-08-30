    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()){
            int m = Q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++){
                TreeNode cur = Q.poll();
                list.add(cur.val);
                if (cur.left != null) Q.add(cur.left);
                if (cur.right != null) Q.add(cur.right);
            }
            res.add(0,list);       
        }
        return res;
    }
