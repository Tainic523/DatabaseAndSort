package Tree;

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

    TreeNode() {
    }

    ;

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

    boolean isComplete(TreeNode root) {// 判断一棵树是否是完全二叉树
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
            } else {
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
            } else {
                //一旦某元素没有左节点或右节点，则之后所有的元素都不应该有子元素
                noChild = true;
            }
        }
        return true;

    }

    boolean iscomplete(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        boolean isLeaf = false;
        TreeNode left;
        TreeNode right;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            left = temp.left;
            right = temp.right;
            if (isLeaf && (left != null || right != null) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                isLeaf = true;
            }
        }
        return true;
    }

    boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        boolean left = isSame(r1.left, r2.left);
        boolean right = isSame(r1.right, r2.right);
        return left && right;
    }

    boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        boolean left = isSame(r1.left, r2.right);
        boolean right = isSame(r1.right, r2.left);
        return left && right;
    }

    void reverse(TreeNode root) { // 递归版本
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.right);
        reverse(root.left);
    }

    void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        TreeNode temp;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.left != null || cur.right != null) {
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
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
        if (p == null) {  // 如果节点为空  直接返回
            return paths;
        }
        path.add(p.val); // 若当前节点不为空  则加入到当前路径 path
        if (p.left != null)
            FindAllPath(p.left); // 走到这一步说明当前节点的子节点不为空 于是递归
        if (p.right != null)
            FindAllPath(p.right);
        if (p.left == null && p.right == null) {   // 若当前节点的 孩子节点均为空 则表示已经到了叶子节点
            paths.add(new ArrayList<>(path));  // 所以将当前路径加入到总得路径里面去
        }
        path.remove(path.size() - 1); // 当前节点访问结束之后，递归函数将自动回到它的父节点。
        // 因此我们在函数退出之前要在路径上删除当前节点
        // 以确保返回父节点时路径刚好是从根节点到父节点的路径。
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

    // 前序和中序 还原二叉树
    public TreeNode buildTreeUsePreAndMid(int[] pre, int[] mid) {
        TreeNode root = new TreeNode();
        if (pre.length != mid.length) {
            return root;
        }
        root = buildTreeHelper(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        return root;
    }

    private TreeNode buildTreeHelper(int[] pre, int preBegin, int preEnd, int[] mid, int midBegin, int midEnd) {
        if (preBegin > preEnd || midBegin > midEnd) {
            return null;
        }
        int val = pre[preBegin];   // 创建当前节点
        TreeNode head = new TreeNode(val);
        int index = findIndex(mid, midBegin, midEnd, head); // 记录根节点的下标
        int offset = index - midBegin - 1;  // 记录左子树的节点数量
        TreeNode left = buildTreeHelper(
                pre, preBegin + 1, preBegin + offset + 1,
                mid, midBegin, midBegin + offset);
        TreeNode right = buildTreeHelper(
                pre, preBegin + offset + 2, preEnd,
                mid, index + 1, midEnd);
        head.left = left;
        head.right = right;
        return head;
    }

    private int findIndex(int[] mid, int midBegin, int midEnd, TreeNode head) { // 找到根节点下标的函数。
        for (int i = midBegin; i <= midEnd; i++) {
            if (head.val == mid[i]) {
                return i;
            }
        }
        return -1;
    }

    // 后序和中序还原二叉树
    public TreeNode buildTreeUseAfterAndMid(int[] after, int[] mid) {
        TreeNode root = new TreeNode();
        if (after.length != mid.length) {
            return root;
        }
        root = buildTreeHelper1(after, 0, after.length - 1, mid, 0, mid.length - 1);
        return root;
    }

    private TreeNode buildTreeHelper1(int[] after, int afterBegin, int afterEnd, int[] mid, int midBegin, int midEnd) {
        if (afterBegin > afterEnd || midBegin > midEnd) {
            return null;
        }
        int val = after[afterEnd];
        TreeNode head = new TreeNode(val);
        int index = findIndex(mid, midBegin, midEnd, head);
        int offset = index - midBegin - 1;
        TreeNode left = buildTreeHelper1
                (after, afterBegin, afterBegin + offset, // 左节点从 前序序列中的属于左子树的部分找
                        mid, midBegin, midBegin + offset);  // 右节点从 前序序列中的属于右子树的部分找
        TreeNode right = buildTreeHelper1
                (after, afterBegin + offset + 1, afterEnd - 1,
                        mid, index + 1, midEnd);
        head.left = left;
        head.right = right;
        return head;
    }
}
