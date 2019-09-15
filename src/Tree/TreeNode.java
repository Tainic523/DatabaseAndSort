package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }

    int maxDepth(TreeNode p) { // 求深度
        if (p == null) {
            return 0;
        } else {
            int left = maxDepth(p.left);
            int right = maxDepth(p.right);
            return Math.max(left, right) + 1;
        }
    }

    int minDepth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        return getMin(p);
    }

    private int getMin(TreeNode p) {
        if (p == null) {
            return Integer.MAX_VALUE;
        }
        if (p.left == null && p.right == null) {
            return 1;
        }
        return Math.min(getMin(p.left), getMin(p.right)) + 1;
    }

    int kLevelNumber(TreeNode p, int k) { // 求二叉树中第k层节点的个数
        if (k < 0 || p == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int left = kLevelNumber(p.left, k - 1);
        int right = kLevelNumber(p.right, k - 1);
        return left + right;
    }

    boolean isBalance(TreeNode p) { // 判断是否平衡二叉树
        if (p == null) {
            return true;
        }
        if (Math.abs(maxDepth(p.left) - maxDepth(p.right)) <= 1) {
            return isBalance(p.left) && isBalance(p.right);
        }
        return false;
    }

    boolean isComplete(TreeNode root){// 判断一棵树是否是完全二叉树
        if (root == null) {
            return true;
        }
        boolean noChild = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {

                //如果无孩子标记被置为true，则queue中不应该再有子元素
                if (noChild) {
                    return false;
                }
                queue.offer(cur.left);
            }else {
                //一旦某元素没有左节点或右节点，则之后所有的元素都不应该有子元素
                //并且该元素不应该有右节点
                noChild = true;
            }

            if (cur.right != null) {
                //如果无孩子标记被置为true，则queue中不应该再有子元素
                if (noChild) {
                    return false;
                }
                queue.offer(cur.right);
            }else {
                //一旦某元素没有左节点或右节点，则之后所有的元素都不应该有子元素
                noChild = true;
            }
        }
        return true;

    }
    boolean isSame(TreeNode r1,TreeNode r2){
        if (r1==null && r2==null){
            return true;
        }
        if (r1==null || r2==null){
            return false;
        }
        if (r1.val != r2.val){
            return false;
        }
        boolean left = isSame(r1.left,r2.left);
        boolean right = isSame(r1.right,r2.right);
        return left&&right;
    }
    boolean isMirror(TreeNode r1,TreeNode r2){
        if (r1==null && r2==null){
            return true;
        }
        if (r1==null || r2==null){
            return false;
        }
        if (r1.val != r2.val){
            return false;
        }
        boolean left = isSame(r1.left,r2.right);
        boolean right = isSame(r1.right,r2.left);
        return left&&right;
    }
    void reverse(TreeNode root){ // 递归版本
        if (root==null){
            return ;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;
        reverse(root.right);
        reverse(root.left);
    }
    void Mirror(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        TreeNode temp;
        stack.push(root);
        while (!stack.isEmpty()){
            cur = stack.pop();
            if (cur.left!=null || cur.right!=null){
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }
    }
    ArrayList<Integer> pre(TreeNode p) { // 先序非递归
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                ans.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
        return ans;
    }

    void repre(TreeNode p, ArrayList<Integer> ans) { //先序递归
        ans.add(p.val);
        if (p.left != null) {
            repre(p.left, ans);
        }
        if (p.right != null) {
            repre(p.right, ans);
        }

    }

    ArrayList<Integer> mid(TreeNode p) { // 中序非递归
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                ans.add(p.val);
                p = p.right;
            }
        }
        return ans;
    }

    void remid(TreeNode p, ArrayList<Integer> ans) { // 中序递归
        if (p.left != null) {
            remid(p.left, ans);
        }
        ans.add(p.val);
        if (p.right != null) {
            remid(p.right, ans);
        }

    }

    ArrayList<Integer> after(TreeNode root) { // 后序非递归
        LinkedList<Integer> a = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {  // 后序非递归可以采用先根 后  右节点  在 左节点的 方式遍历
            while (p != null) { // 然后将结果逆序输出即可。
                a.addFirst(p.val); // 访问根节点
                stack.push(p);
                p = p.right;  //  右节点
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.left;  //  左节点
            }
        }
        return new ArrayList<>(a);

    }

    void reafter(TreeNode p, ArrayList<Integer> ans) {  //后序递归
        if (p.left != null) {
            reafter(p.left, ans);
        }
        if (p.right != null) {
            reafter(p.right, ans);
        }
        ans.add(p.val);
    }

    ArrayList<Integer> level(TreeNode root) { //层序非递归
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            ans.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return ans;
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode p) { // 按照之字形打印二叉树
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (p != null) {
            queue.offer(p);
            int level = 1;
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    p = queue.poll();
                    if (level % 2 == 1) {
                        a.addLast(p.val);
                    } else {
                        a.addFirst(p.val);
                    }
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }
                ans.add(new ArrayList<>(a));
                a.clear();
                level++;
            }
        }
        return ans;
    }

    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    ArrayList<ArrayList<Integer>> FindAllPath(TreeNode p) { // 二叉树根节点到叶节点的所有路径
        if (p==null){
            return paths;
        }
        path.add(p.val); // 若当前节点不为空  则加入到当前路径 path
        if (p.left == null && p.right == null) {   // 若当前节点的 孩子节点均为空 则表示已经到了叶子节点
            paths.add(new ArrayList<>(path));  // 所以将当前路径加入到总得路径里面去
        }
        if (p.left != null)
            FindAllPath(p.left); // 走到这一步说明当前节点的子节点不为空 于是递归
        if (p.right != null)
            FindAllPath(p.right);
        path.remove(path.size() - 1); //
        return paths;
    }

    ArrayList<ArrayList<Integer>> FindPath(TreeNode p, int target) { // 和为某个值的所有路径
        ArrayList<ArrayList<Integer>> routes = new ArrayList<>();
        ArrayList<Integer> route = new ArrayList<>();
        if (p == null) return routes;
        FindPathHelper(p, target, route, routes);
        return routes;
    }

    private void FindPathHelper(TreeNode p, int target, ArrayList<Integer> route,
                                ArrayList<ArrayList<Integer>> routes) {
        route.add(p.val);
        if (p.val == target && p.left == null && p.right == null) {
            routes.add(new ArrayList<>(route));
        }
        if (p.left != null)
            FindPathHelper(p.left, target - p.val, route, routes);
        if (p.right != null)
            FindPathHelper(p.right, target - p.val, route, routes);
        route.remove(route.size() - 1);
    }

    private int maxVal = Integer.MIN_VALUE;

    int maxPathSum(TreeNode root) { // 该函数返回是左右的最大路径和
        if (root == null)
            return 0;
        maxCore(root);
        return maxVal;
    }

    // 该函数返回是左右的最大路径和，而非左+右+root的最大值
    // 使用curValue，来标记左+右+root
    private int maxCore(TreeNode root) {
        if (root == null)
            return 0;
        // 求以root为根的当前子树的最大路径和
        // 如果左右子树都是负数，
        // 那么就最大路径就是当前结点值（无论正负）
        int curValue = root.val;
        int lmax = maxCore(root.left);
        int rmax = maxCore(root.right);
        if (lmax > 0)
            curValue += lmax;
        if (rmax > 0)
            curValue += rmax;
        maxVal = Math.max(curValue, maxVal);
        // 返回以当前root为根的子树的最大路径和
        // 左右有可能都为负数，所以需要参与比较大小

        return Math.max(root.val, Math.max(lmax + root.val, rmax + root.val));
    }

}
