package Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        TreeNode p1=new TreeNode(1); //        1
        TreeNode p2=new TreeNode(2);//      2      3
        TreeNode p3=new TreeNode(3);//    4  5   6  7
        TreeNode p4=new TreeNode(4);//  8     7 5
        TreeNode p5=new TreeNode(5);// 前序 ：1, 2, 4, 8, 5, 7, 3, 6, 5, 7
        TreeNode p6=new TreeNode(6);// 中序 ：8, 4, 2, 5, 7, 1, 5, 6, 3, 7
        TreeNode p7=new TreeNode(7);// 后序 ：8, 4, 7, 5, 2, 5, 6, 7, 3, 1
        TreeNode p8=new TreeNode(8);// 层序 ：1, 2, 3, 4, 5, 6, 7, 8, 7, 5
        TreeNode p9=new TreeNode(7);
        TreeNode p10=new TreeNode(5);
        p1.left=p2;p1.right=p3;
        p2.left=p4;p2.right=p5;
        p3.left=p6;p3.right=p7;
        p4.left=p8;p5.right=p9;
        p6.left=p10;
        ArrayList<Integer> ans1=p1.pre(p1);// 先序非递归
        ArrayList<Integer> ans11=new ArrayList<>();//先序递归
        p1.repre(p1,ans11);

        ArrayList<Integer> ans2=p1.mid(p1);// 中序非递归
        ArrayList<Integer> ans22=new ArrayList<>();// 中序递归
        p1.remid(p1,ans22);

        ArrayList<Integer> ans3=p1.after(p1);// 后序非递归
        ArrayList<Integer> ans33=new ArrayList<>(); //后序递归
        p1.reafter(p1,ans33);

        ArrayList<Integer> ans4=p1.level(p1);//层序非递归
        ArrayList<ArrayList<Integer>> ans=p1.FindAllPath(p1);
        ArrayList<ArrayList<Integer> > ans6=p1.FindPath(p1,15);
        int aaans=p1.maxPathSum(p1);
//        Serialize serialize=new Serialize();
//        String s=serialize.Serialize(p1);
//        TreeNode t=serialize.Deserialize(s);
//        ArrayList<Integer> aa=t.pre(t);
        ArrayList<ArrayList<Integer> > ans5=p1.Print(p1);


        System.out.println("先序非递归:  "+ans1);
        System.out.println("先序递归:    "+ans11);
        System.out.println("中序非递归:  "+ans2);
        System.out.println("中序递归:    "+ans22);
        System.out.println("后序非递归:  "+ans3);
        System.out.println("后序递归:    "+ans33);
        System.out.println("层序非递归:  "+ans4);
        System.out.println("之字形打印二叉树:  "+ans5);
//        System.out.println(s);
//        System.out.println(aa);
        System.out.println("二叉树所有路径： "+ans);
        System.out.println("二叉树所有路径之和为15的路径 ： "+ans6);
        System.out.println("任意两个节点之间的路径之和的最大值为 "+aaans);
//        float ss= 9.7f;
//        Float sss=new Float(9.7f);
//        System.out.println(Float.floatToIntBits(sss));
//        String string="absssss";
//        StringBuffer stringBuffer=new StringBuffer(string);
//        System.out.println(stringBuffer.reverse());



    }




}
