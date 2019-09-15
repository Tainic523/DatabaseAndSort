package jd;

//import java.util.Scanner;

import java.util.Scanner;

public class Main {

    static int fun(String[] str, String pattern) {
        int[] flag = new int[pattern.length()];
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (pattern.contains(str[i]))
                count++;
        }
        return count;
    }

    //    static void fun(int[] flag,int begin,int end){ // 之一
//        for (int i=begin;i<=end;i++){
//            flag[i]=1;
//        }
//    }
//    static void fun(int[] flag){
//
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] s = new String[m + 1];
        for (int i = 0; i <= m; i++) {
            s[i] = sc.next();
        }
        String[] str = new String[m];
        for (int i = 0; i < m; i++) {
            str[i] = s[i];
        }
        String pattern = s[m];

        System.out.print(fun(str, pattern));



    }

}





