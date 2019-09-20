package Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1); //        1
        TreeNode p2 = new TreeNode(2);//      2      3
        TreeNode p3 = new TreeNode(3);//    4  5   6  7
        TreeNode p4 = new TreeNode(4);//  8     7 5
        TreeNode p5 = new TreeNode(5);// 前序 ：1, 2, 4, 8, 5, 7, 3, 6, 5, 7
        TreeNode p6 = new TreeNode(6);// 中序 ：8, 4, 2, 5, 7, 1, 5, 6, 3, 7
        TreeNode p7 = new TreeNode(7);// 后序 ：8, 4, 7, 5, 2, 5, 6, 7, 3, 1
        TreeNode p8 = new TreeNode(8);// 层序 ：1, 2, 3, 4, 5, 6, 7, 8, 7, 5
        TreeNode p9 = new TreeNode(7);
        TreeNode p10 = new TreeNode(5);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        p4.left = p8;
        p5.right = p9;
        p6.left = p10;
        ArrayList<Integer> pre = p1.pre(p1);// 先序非递归
        ArrayList<Integer> preRe = new ArrayList<>();//先序递归
        p1.repre(p1, preRe);
        int[] preArray = new int[pre.size()];
        for (int i = 0; i < preArray.length; i++) {
            preArray[i] = pre.get(i);
        }
        ArrayList<Integer> mid = p1.mid(p1);// 中序非递归
        ArrayList<Integer> midRe = new ArrayList<>();// 中序递归
        p1.remid(p1, midRe);
        int[] midArray = new int[mid.size()];
        for (int i = 0; i < midArray.length; i++) {
            midArray[i] = mid.get(i);
        }
        ArrayList<Integer> after = p1.after(p1);// 后序非递归
        ArrayList<Integer> afterRe = new ArrayList<>(); //后序递归
        p1.reafter(p1, afterRe);
        int[] afterArray = new int[after.size()];
        for (int i = 0; i < afterArray.length; i++) {
            afterArray[i] = after.get(i);
        }

        TreeNode root = p1.buildTreeUsePreAndMid(preArray, midArray);

        ArrayList<Integer> level = p1.level(root);//层序非递归
        ArrayList<ArrayList<Integer>> allPath = p1.FindAllPath(p1);
        ArrayList<ArrayList<Integer>> TargetPath = p1.FindPath(p1, 13);
        int aaans = p1.maxPathSum(p1);
//        Serialize serialize=new Serialize();
//        String s=serialize.Serialize(p1);
//        TreeNode t=serialize.Deserialize(s);
//        ArrayList<Integer> aa=t.pre(t);
        TreeNode root2 = p1.buildTreeUseAfterAndMid(afterArray, midArray);
        ArrayList<ArrayList<Integer>> ans5 = p1.Print(root2); // 之字形打印二叉树
        int depth = p1.maxDepth(p1);
        Serialize serialize = new Serialize();
        String sans = serialize.Serialize(p1);
        TreeNode pp = serialize.Deserialize(sans);
        ArrayList<Integer> de = p1.pre(p1);// 先序非递归
        System.out.println(sans);
        System.out.println("第三层的节点数为  " + p1.kLevelNumber(p1, 3));
        System.out.println("是否平衡二叉树  " + p1.isBalance(p1));
        System.out.println("是否完全二叉树  " + p1.iscomplete(p1));
        System.out.println("是否相等二叉树   " + p1.isSame(p1, p1));
        System.out.println("是否镜像二叉树   " + p1.isMirror(p1, p1));
        System.out.println("最大深度为：  " + depth);
        System.out.println("最小深度为：  " + p1.minDepth(p1));
        System.out.println("先序非递归:  " + pre);
        System.out.println("先序递归:    " + preRe);
        System.out.println("中序非递归:  " + mid);
        System.out.println("中序递归:    " + midRe);
        System.out.println("后序非递归:  " + after);
        System.out.println("后序递归:    " + afterRe);
        System.out.println("层序非递归:  " + level);
        System.out.println("之字形打印二叉树:  " + ans5);
//        System.out.println(s);
//        System.out.println(aa);
        System.out.println("二叉树所有路径： " + allPath);
        System.out.println("二叉树所有路径之和为15的路径 ： " + TargetPath);
        System.out.println("任意两个节点之间的路径之和的最大值为 " + aaans);
        System.out.println(depth);

        p1.Mirror(p1);
        ArrayList<Integer> ansreverse = p1.pre(p1);
        System.out.println(ansreverse);
//        float ss= 9.7f;
//        Float sss=new Float(9.7f);
//        System.out.println(Float.floatToIntBits(sss));
//        String string="absssss";
//        StringBuffer stringBuffer=new StringBuffer(string);
//        System.out.println(stringBuffer.reverse());


    }


}
