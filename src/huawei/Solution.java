package huawei;

import java.util.*;

public class Solution {
    static LinkedList<Integer> fun(int m, LinkedList<LinkedList<Integer>> a){
        LinkedList<Integer> ans =new LinkedList<>();
        while(!isdone(a)){
            for (LinkedList<Integer> aa: a){
                if (aa.size()>m){
                    for (int j=0;j<m;j++){
                        ans.add(aa.pollFirst());
                    }
                }
                else {
                    ans.addAll(aa);
                    aa.clear();
                }
            }
        }
        return ans;
    }
    static boolean isdone(LinkedList<LinkedList<Integer>> a){
        for (LinkedList<Integer> aa:a){
            if (aa.size()!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args ){
        Scanner sc1=new Scanner(System.in);
//        String s=sc1.nextLine();
//        int m=Integer.parseInt(s);
        int m=sc1.nextInt();
        LinkedList<LinkedList<Integer>> ans=new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        while (true){
            String ss=sc.nextLine();
            if (ss.equals(""))
                break;
            String[] str=ss.split(",");
            LinkedList<Integer> a = new LinkedList<>();
            for (int j=0;j<str.length;j++){
                    a.add(Integer.parseInt(str[j]));
            }
            ans.add(a);
        }
        System.out.println(ans);
        LinkedList<Integer> array= fun(m,ans);
        for (int i=0;i<array.size();i++
             ) {
            System.out.print(array.get(i));
            if (i!=array.size()-1)
                System.out.print(',');
        }
    }
}
