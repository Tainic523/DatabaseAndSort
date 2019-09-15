package HuaWeiplus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution2 {
     static ArrayList<ArrayList<Character>> number=new ArrayList<>();
     static void fun1(){
        String[] s={"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i=0;i<s.length;i++){
            ArrayList<Character> list=new ArrayList<>();
            for (int j=0;j<s[i].length();j++){
                list.add(s[i].charAt(j));
            }
            number.add(list);
        }
    }
    private static ArrayList<Integer> fun2(ArrayList<Character> list) {
        ArrayList<Integer> ans=new ArrayList<>();
        int[] a={0,8,6,3,4,5,7,9,1,2};
        for (int i=0;i<number.size();i++){
            while (list.containsAll(number.get(a[i]))){
                for (int j=0;j<number.get(a[i]).size();j++)
                {
                    list.remove(number.get(a[i]).get(j));
                }
                ans.add(a[i]);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        fun1();
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.toLowerCase();

        ArrayList<Character> arrayList=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            arrayList.add(s.charAt(i));
        }
        ArrayList<Integer> number=fun2(arrayList);
        for (Integer i: number
             ) {
            System.out.print(i);

        }

    }
}
